#!/usr/bin/env python3
"""
Reconstruct readable ES module source from the minified Next.js page chunk
recovered out of FinanceApp.apk.

Input : recovered/bundles/app__page-25b2c23d00617ffc.js   (prettier-formatted)
Output: src/app/page.jsx

The transform is purely mechanical: it strips the webpack runtime wrapper,
replaces the `i(57437)`-style require graph with real ESM imports, and
renames the 15 module-scoped identifiers that the minifier mangled. No
application logic is altered.
"""
import re, sys, pathlib

ROOT = pathlib.Path(__file__).resolve().parent.parent
SRC = ROOT / "recovered/bundles/app__page-25b2c23d00617ffc.js"
DST = ROOT / "src/app/page.jsx"

# module id -> (minified var, real import specifier, real local name)
IMPORTS = [
    (57437, "s", "react/jsx-runtime", None),                       # jsx, jsxs
    (2265,  "n", "react", None),                                    # useState/useEffect
    (26836, "o", "@capacitor/camera", None),                        # Camera/CameraResultType/CameraSource
    (2468,  "r", "@capacitor/local-notifications", "LocalNotifications"),
    (56689, "l", "@capacitor/core", None),                          # Capacitor
    (47625, "a", "recharts", "ResponsiveContainer"),
    (5481,  "d", "recharts", "AreaChart"),
    (56940, "c", "recharts", "CartesianGrid"),
    (97059, "h", "recharts", "XAxis"),
    (62994, "f", "recharts", "YAxis"),
    (8147,  "x", "recharts", "Tooltip"),
    (23263, "p", "recharts", "Area"),
    (75169, "g", "recharts", "PieChart"),
    (3574,  "u", "recharts", "Pie"),
    (20407, "m", "recharts", "Cell"),
    (77031, "y", "recharts", "BarChart"),
    (31699, "j", "recharts", "Bar"),
]
# lucide-react icons: minified var -> icon name (all exported as `.Z`)
ICONS = {
    "b": "Boxes", "v": "ArrowLeftRight", "S": "FileText", "k": "Plus",
    "z": "Percent", "w": "Send", "C": "Copy", "F": "Share2", "R": "Heart",
    "I": "ChevronDown", "W": "Bell", "E": "Sun", "B": "Moon",
    "N": "ArrowUpRight", "D": "BarChart3", "A": "Target", "T": "Receipt",
    "P": "Calendar", "L": "CreditCard", "$": "Search", "Z": "X",
    "U": "Check", "M": "User", "Y": "Umbrella", "q": "Camera",
    "O": "Bike", "G": "ChevronLeft", "H": "SlidersHorizontal",
    "V": "ArrowRight", "X": "Zap", "K": "MessageCircle", "_": "Ellipsis",
    "J": "Download", "Q": "Trash2", "ee": "Sparkles", "et": "Wallet",
    "ei": "TrendingUp",
}
# minified top-level identifier -> descriptive name
COMPONENTS = {
    "es": "theme", "en": "Toast", "eo": "Sheet", "er": "Pressable",
    "el": "Screen", "ea": "TabBar", "ed": "Dashboard", "ec": "Spaces",
    "eh": "Invoices", "ef": "Receipts", "ex": "Analytics", "ep": "Budgets",
    "eg": "Subscriptions", "eu": "App", "em": "Page",
}

lines = SRC.read_text().split("\n")
# module 52197 spans "52197: function (e, t, i) {" .. the matching "},"
start = next(i for i, l in enumerate(lines) if re.match(r"^    52197: function", l))
end = len(lines)
for i in range(start + 1, len(lines)):
    if lines[i].rstrip() == "    },":
        end = i
        break
body = "\n".join(lines[start + 1:end])

# 1. drop the webpack export registration
body = re.sub(r'^\s*"use strict";\s*\n', "", body)
body = re.sub(r"^\s*i\.r\(t\),\s*\n", "", body)
body = re.sub(r"^\s*i\.d\(t, \{.*?\}\);\s*\n", "", body, flags=re.S)

# 2. replace the require graph with real imports
def import_block(_m):
    out = ['"use client";\n']
    out.append('import * as s from "react/jsx-runtime";')
    out.append('import * as n from "react";')
    out.append('import { Capacitor } from "@capacitor/core";')
    out.append('import { Camera, CameraResultType, CameraSource } from "@capacitor/camera";')
    out.append('import { LocalNotifications } from "@capacitor/local-notifications";')
    recharts = ["ResponsiveContainer", "AreaChart", "CartesianGrid", "XAxis", "YAxis",
                "Tooltip", "Area", "PieChart", "Pie", "Cell", "BarChart", "Bar"]
    out.append("import {\n  " + ",\n  ".join(recharts) + ",\n} from \"recharts\";")
    icons = ", ".join(
        f"{name} as CameraIcon" if name == "Camera" else name
        for _var, name in sorted(ICONS.items(), key=lambda kv: kv[1])
    )
    out.append("import {\n  " + icons.replace(", ", ",\n  ") + ",\n} from \"lucide-react\";")
    return "\n".join(out) + "\n"

# 2. replace the require graph with real imports
body, n_imports = re.subn(
    r"^\s*var s = i\(57437\),.*?ei = i\(70525\);\s*$",
    import_block, body, count=1, flags=re.S | re.M,
)
if n_imports != 1:
    sys.exit("FATAL: require graph not matched")

# 3. member-expression rewrites (module-scoped, unambiguous)
body = re.sub(r"(?<![\w$.])l\.dV\b", "Capacitor", body)
body = re.sub(r"(?<![\w$.])o\.V1\b", "Camera", body)
body = re.sub(r"(?<![\w$.])o\.dk\b", "CameraResultType", body)
body = re.sub(r"(?<![\w$.])o\.oK\b", "CameraSource", body)
body = re.sub(r"(?<![\w$.])r\.s\.(?=[A-Za-z_$])", "LocalNotifications.", body)
for _mid, var, _spec, alias in IMPORTS:
    if alias:
        body = re.sub(r"(?<![\w$.])%s\.[A-Za-z_$]{1,3}\b" % re.escape(var), alias, body)
for var, name in ICONS.items():
    body = re.sub(r"(?<![\w$.])%s\.Z\b" % re.escape(var), f"{name}_icon", body)

# 4. identifier renames (verified shadow-free in tools/verify-renames.py)
for old, new in COMPONENTS.items():
    body = re.sub(r"(?<![\w$.])%s(?![\w$])" % re.escape(old), new, body)

# 5. tidy indentation (module body was nested one level)
body = "\n".join(l[2:] if l.startswith("  ") else l for l in body.split("\n"))

header = '''/**
 * FinanceApp - main application screen.
 *
 * RECONSTRUCTED SOURCE. Recovered from the production JavaScript bundle inside
 * FinanceApp.apk (com.financeapp) by tools/de-minify.py. Application logic is
 * byte-faithful to the shipped bundle; only module-scoped identifiers and the
 * webpack require graph were rewritten. See RECOVERY.md for fidelity notes.
 */
'''
DST.parent.mkdir(parents=True, exist_ok=True)
DST.write_text(header + body.strip() + "\n")
print(f"wrote {DST.relative_to(ROOT)}  ({len(body.splitlines())} lines)")
