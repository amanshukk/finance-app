# Recovery notes

Provenance, method, and fidelity limits for the reconstruction in this repository.
Read this before relying on any of it.

## Source artifact

| | |
|---|---|
| Input | `FinanceApp.apk` |
| Size | 9,625,595 bytes |
| MD5 | `6c1357ab7fb018470b8b09ac07e18b83` |
| Type | Android package, 995 entries, 8 DEX files |

## Architecture, and why the result is unusually good

The APK is **not** a native-compiled app. It is a Capacitor shell whose entire
application payload is a **Next.js static export** shipped as plain, unencrypted
JavaScript under `assets/public/`:

```
assets/capacitor.config.json     appId com.financeapp, webDir "out"
assets/public/index.html         exported HTML
assets/public/index.txt          RSC flight payload (metadata, component tree)
assets/public/_next/static/…     JS chunks + compiled CSS
```

This matters: the web layer of the app was never obfuscated or compiled to native
code. The JavaScript in the APK *is* the application's own logic, minified but
otherwise intact and directly readable. For a hybrid app this is close to the best
case — far better than reverse-engineering Dalvik.

The native side, by contrast, is boilerplate: `MainActivity extends BridgeActivity`
and nothing else. All real code is in the web layer.

## Method

1. **Extract** the APK; `assets/public/` copied verbatim to `out/`.
2. **Pretty-print** every JS chunk with Prettier into `recovered/bundles/`.
3. **Resolve the require graph.** Each `i(<id>)` in the page chunk was located in the
   chunk that defines it and identified by its contents — `chartName:"AreaChart"`,
   `displayName="Cell"`, `createLucideIcon("Boxes")`, the `Day` enum, and so on. This
   is how the dependency list in the README was established rather than guessed.
4. **De-minify** the page module with `tools/de-minify.py`: strip the webpack
   wrapper, replace the require graph with real ESM imports, rename the 15
   module-scoped identifiers.
5. **Decompile** the native side with jadx 1.5.2.

## Fidelity

**Faithful** — recovered exactly, not reconstructed:

- `out/` — all web assets, byte-for-byte as shipped.
- `recovered/bundles/` — the shipped JavaScript, only reformatted.
- `android-decompiled/` — jadx output. `com/financeapp/MainActivity.java` and the
  decoded `AndroidManifest.xml` are exact and trivial.
- Application logic inside `src/app/page.jsx`. Every statement, literal, style object,
  and hardcoded dataset is the original. The 15 renamed identifiers are the *only*
  textual change.

**Derived, not original:**

- `src/app/page.jsx` is JavaScript with JSX, not the original TSX. Original file
  boundaries, prop types, variable names, comments, and any helper module are gone.
- `src/app/layout.jsx` was written from the RSC payload in `out/index.txt`; the
  compiled layout chunk is an empty module, so there was nothing to recover.
- `src/app/globals.css` reassembles the two custom rules from the compiled Tailwind
  output. Which source file they lived in is unknown.
- `package.json`, `next.config.mjs`, `tailwind.config.js`, `postcss.config.js`,
  `capacitor.config.ts` — inferred, not recovered. `capacitor.config.ts` is the one
  exception: it is a verbatim transcription of `assets/capacitor.config.json`.

### Identifier renames

The transform renames 15 module-scoped identifiers. Each was checked for shadowing
before renaming (every occurrence accounted for as a declaration, a member access, or
a JSX reference), so the renames are semantics-preserving:

| Minified | Recovered | | Minified | Recovered |
|---|---|---|---|---|
| `es` | `theme` | | `ed` | `Dashboard` |
| `en` | `Toast` | | `ec` | `Spaces` |
| `eo` | `Sheet` | | `eh` | `Invoices` |
| `er` | `Pressable` | | `ef` | `Receipts` |
| `el` | `Screen` | | `ex` | `Analytics` |
| `ea` | `TabBar` | | `ep` | `Budgets` |
| `em` | `Page` | | `eg` | `Subscriptions` |
| | | | `eu` | `App` |

Library imports are restored by name: all 38 Lucide icons (`b.Z` → `Boxes`, …), 12
Recharts components (`d.T` → `AreaChart`, `j.$` → `Bar`, …), and the Capacitor
symbols (`l.dV` → `Capacitor`, `o.V1` → `Camera`, `r.s` → `LocalNotifications`).

Everything *inside* component bodies is still minified single-letter local
variables. De-minifying those is not reliably possible — `let { children: t, onPress:
i, style: o }` cannot be distinguished from a dozen other destructuring patterns
without type information — so they were deliberately left alone. Readability stops at
the component boundary.

## What could not be recovered

- **Original source.** The APK ships **no source maps** (`.map` count: 0) and was
  built in production mode. The original `.tsx` files, TypeScript types, variable
  names, and file layout are unrecoverable. What is here is the compiled output,
  de-minified — not the source that produced it.
- **Build configuration.** No `next.config`, Tailwind config, or Gradle files were
  packaged. The versions in `package.json` marked `^` are inferred from bundle
  contents; only `next@14.2.35`, `react@18.3.1`, and `tailwindcss@3.4.19` were
  positively identified.
- **Git history, tests, CI, backend.** None present.
- **The Android Gradle project.** Regenerable via `npx cap add android`; excluded here
  to keep the repository at 8 MB instead of 60 MB.

## Findings worth acting on

1. **The shipped APK is a debug build.** `AndroidManifest.xml` sets
   `android:debuggable="true"` and `android:allowBackup="true"`. A debuggable release
   APK allows attaching a debugger to the process and, on older devices, adb access to
   app-private storage. This is typically not intended for distribution.
2. **A referenced animation is missing.** `Toast` animates with
   `animation: "toastIn 0.4s cubic-bezier(…)"`, but no `@keyframes toastIn` exists in
   the shipped stylesheet — the single compiled CSS file ends at the `body,html` rule.
   The toast therefore appears without animating. Either the keyframes were never
   added, or a stylesheet failed to make it into the build.
3. **Axios is bundled but unused.** An Axios 3.38.1 banner is present in the vendor
   chunk, yet no application chunk references it. Dead weight in the bundle, and a
   hint that a networking layer was started and abandoned.
4. **All data is hardcoded.** Account balances, transactions, invoices, and budgets are
   inline literals in the component bodies. There is no API client, so the app cannot
   persist anything — state resets on reload. Expected for a prototype, but it means
   the reconstructed `Dashboard`/`Invoices`/etc. are display-only.

## Tooling

| Tool | Version | Role |
|---|---|---|
| jadx | 1.5.2 | DEX → Java, binary resources → XML |
| Prettier | 3.3.3 | Bundle formatting |
| OpenJDK | 21 | jadx runtime |
| Node.js | — | transform script, build |

jadx reported 16 errors on a 3,735-class APK, which is normal for decompilation. All
errors are in third-party library code; `com.financeapp` decompiled cleanly.
