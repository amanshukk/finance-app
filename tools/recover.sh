#!/usr/bin/env bash
# Re-run the full recovery pipeline against an APK.
#
#   ./tools/recover.sh /path/to/FinanceApp.apk
#
# Produces, relative to the repo root:
#   out/                 exact web assets served by the app
#   recovered/bundles/   the same chunks, pretty-printed
#   android-decompiled/  jadx output (Java sources + decoded resources)
#   src/app/page.jsx     reconstructed, readable application source
set -euo pipefail

APK="${1:?usage: recover.sh <path-to.apk>}"
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

command -v unzip  >/dev/null || { echo "need: unzip";  exit 1; }
command -v java   >/dev/null || { echo "need: java (JRE 11+)"; exit 1; }
[ -d node_modules/prettier ] || npm install --no-audit --no-fund

WORK="$(mktemp -d)"
trap 'rm -rf "$WORK"' EXIT

echo "==> extracting APK"
unzip -q -o "$APK" -d "$WORK/apk"

echo "==> collecting web assets"
rm -rf out recovered/bundles
mkdir -p out recovered/bundles
cp -r "$WORK/apk/assets/public/." out/
cp "$WORK/apk/assets/capacitor.config.json" out/ 2>/dev/null || true

echo "==> pretty-printing bundles"
for f in out/_next/static/chunks/*.js; do
  n="$(echo "${f#out/_next/static/chunks/}" | tr '/' '_')"
  node node_modules/prettier/bin/prettier.cjs --parser babel "$f" \
    > "recovered/bundles/$n"
done

echo "==> decompiling native code (jadx)"
JADX="${JADX_JAR:-/tmp/jadx-bin/lib/jadx-1.5.2-all.jar}"
if [ -f "$JADX" ]; then
  rm -rf android-decompiled
  java -Djava.awt.headless=true -Xmx1200m -cp "$JADX" jadx.cli.JadxCLI \
    -j 1 -d android-decompiled --show-bad-code "$APK" || true
else
  echo "    skipped (jadx jar not found; set JADX_JAR)"
fi

echo "==> reconstructing src/app/page.jsx"
python3 tools/de-minify.py

echo "==> done"
