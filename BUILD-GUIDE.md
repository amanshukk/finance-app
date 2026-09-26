# Build guide — reproducing FinanceApp exactly

This is the spec. If you are rebuilding or extending this app, follow it exactly.
The goal is a build that is **indistinguishable from the shipped APK**. Where this
guide says "do not change", that is not a suggestion.

## The one rule

**`out/` is the ground truth. `src/app/page.jsx` is the reference implementation.**

`out/` is the compiled app itself, extracted byte-for-byte from the APK. It is the
only artifact that is definitionally identical to what shipped. When a rebuild and
`out/` disagree, **`out/` is right and your rebuild is wrong.** Do not "fix" the app
to match your expectations.

To see the original app, open `out/index.html` in a browser. No server needed.

## Do not change these

| Item | Why |
|---|---|
| **Do not add `@keyframes toastIn`** | `Toast` references `animation: "toastIn 0.4s …"` but **no such keyframes exist** in the shipped CSS. The toast intentionally appears without animating. Adding the keyframes is a visible UI change. This is a bug in the original — reproduce it, don't fix it. |
| **Do not rename or restructure the 14 components** | They are the recovered originals. `Dashboard` is 1,226 lines; `Receipts` is 1,034. Keep them. |
| **Do not "upgrade" the 3 inferred dependencies** | Recharts, Lucide and Capacitor versions are not recoverable from the APK. Using a different major can shift chart rendering. |
| **Do not replace inline styles with Tailwind** | ~80% of the UI is inline style objects. Converting them changes specificity and spacing. |
| **Do not add a backend, auth, or persistence** | The original has none. State resets on reload by design. |
| **Do not change any hex colour** | See the design tokens below. They are exact. |

## Pinned versions

Exact, recovered from bundle contents:

```
next        14.2.35
react       18.3.1
react-dom   18.3.1
tailwindcss 3.4.19
```

Inferred — best guess, do not freely bump:

```
recharts, lucide-react, @capacitor/{core,camera,local-notifications}
```

## Design tokens

Recovered verbatim from the `theme` object (line 79 of `src/app/page.jsx`):

| Token | Value | | Token | Value |
|---|---|---|---|---|
| `bg` | `#F1F0ED` | | `chip` | `#F4F3F0` |
| `ink` | `#17171A` | | `leatherLight` | `#6B4632` |
| `sub` | `#9A9A9E` | | `leatherDark` | `#2E1B12` |
| `faint` | `#C7C6C3` | | `cardMetal1` | `#3A3B3E` |
| `line` | `#E7E5E1` | | `cardMetal2` | `#0B0B0C` |
| `green` | `#22C55E` | | `cardGold1` | `#E8CFA0` |
| `blue` | `#0A84FF` | | `cardGold2` | `#9A7B4F` |
| `orange` | `#FF9F0A` | | | |

The app is light-mode by default with a dark toggle. `Screen` caps width at 480px
and centres it, so the layout is a phone frame on any device.

## Components

All in `src/app/page.jsx`. Line numbers are from the current file.

| Line | Component | Responsibility |
|---:|---|---|
| 87 | `Toast` | Transient message, auto-dismisses after 2200ms. **See the `toastIn` rule.** |
| 114 | `Sheet` | Full-screen modal overlay, tap-to-close |
| 178 | `Pressable` | Button primitive with press-opacity feedback. Used 65× |
| 203 | `Screen` | 480px phone frame + background |
| 221 | `TabBar` | Bottom nav: dashboard / spaces / invoice + quick-add |
| 286 | `Dashboard` | Net worth area chart, category pie, accounts, transactions |
| 1512 | `Spaces` | Savings pots; move money between spaces |
| 1929 | `Invoices` | Invoice list + detail (`IN-001`), line items, auto-reminder |
| 2619 | `Receipts` | Receipt capture + filing. **Calls the Camera plugin** |
| 3653 | `Analytics` | Income vs expenses bars, totals, savings rate |
| 3948 | `Budgets` | Per-category budgets, spent/remaining |
| 4300 | `Subscriptions` | Recurring services |
| 4718 | `App` | Root. Owns dark mode, toast, modal, navigation state |
| 5786 | `Page` | Default export; renders `App` |

`App` passes `showToast`, `showModal`, `onNavigate`, `darkMode`, `toggleDarkMode`
down to the screen components. `Spaces` receives only the first three.

## Tailwind classes

Exactly 53 utility classes are used, and **all 53 are present in the compiled CSS**
(verified). If your build emits a class not on this list, you have introduced a
change. The compiled rules are in `out/_next/static/css/54b636a4fdda4c2a.css`.

```
flex flex-1 flex-col flex-wrap gap-1 gap-1.5 gap-2 gap-2.5 gap-3 gap-4 gap-6
grid grid-cols-2 h-full items-center items-end justify-between justify-center
mb-2 mb-3 mb-6 mt-1 mt-1.5 mt-2 mt-2.5 mt-3 mt-4 mt-5 mx-5 mx-6 overflow-x-auto
p-3 p-4 p-5 pb-1 pb-2 pb-4 pb-5 pb-6 pt-0.5 pt-1 pt-2 pt-3 pt-4 pt-5 pt-6
px-2 px-3 px-5 px-6 py-1.5 py-3 text-center
```

`globals.css` contributes only these non-Tailwind rules, which are exact:

```css
* { margin: 0; padding: 0; box-sizing: border-box; }
body, html { height: 100%; width: 100%; overflow: hidden; background: #f1f0ed; }
```

## Rebuilding the web app

```bash
npm install
npm run build     # static export -> out/
```

`next.config.mjs` uses `output: "export"`, which is what Capacitor's `webDir: "out"`
expects. If you switch to a Node server build, `cap sync` will break.

## Rebuilding the Android app

The Gradle project is not in this repo — it is scaffolder boilerplate. Recreate it:

```bash
npm run build
npx cap add android
npx cap sync
```

Required Android config, from the decoded manifest:

| Setting | Value |
|---|---|
| `applicationId` | `com.financeapp` |
| `appName` / label | `FinanceApp` |
| `minSdkVersion` | 24 |
| `targetSdkVersion` | 36 |
| `compileSdkVersion` | 36 |
| `versionCode` / `versionName` | 1 / `1.0.0` |

The entire native surface is one class:

```java
package com.financeapp;
import com.getcapacitor.BridgeActivity;
public class MainActivity extends BridgeActivity {}
```

**Restore the launcher icon** from `android-decompiled/resources/res/` after
`cap add android` — the scaffolder will otherwise generate the default Capacitor
icon, which is a visible difference:

```
res/mipmap-anydpi-v26/ic_launcher.xml          adaptive icon
res/mipmap-anydpi-v26/ic_launcher_round.xml
res/drawable/ic_launcher_background.xml        (colour #ffffff, see values/colors.xml)
res/drawable/ic_launcher_foreground.xml
res/mipmap-{m,h,xh,xxh,xxxh}dpi/ic_launcher.png
res/mipmap-{m,h,xh,xxh,xxxh}dpi/ic_launcher_round.png
res/mipmap-{m,h,xh,xxh,xxxh}dpi/ic_launcher_foreground.png
```

The icon is a teal-to-emerald gradient rounded square with a white "F" whose
mid-bar flows into a rising trend arrow (regenerated 2026-09-26 with
`tools/make_logo.py`, replacing the original black/white "F").

Permissions, from the manifest — only these are requested:

```
CAMERA, POST_NOTIFICATIONS, RECEIVE_BOOT_COMPLETED, VIBRATE,
READ_EXTERNAL_STORAGE (maxSdk 32), WRITE_EXTERNAL_STORAGE (maxSdk 28),
READ_MEDIA_IMAGES, INTERNET, WAKE_LOCK
```

## Native plugins

Exactly two, confirmed by `capacitor.plugins.json` in the APK:

- `@capacitor/camera` → `CameraPlugin` — receipt capture, base64 result
- `@capacitor/local-notifications` → `LocalNotificationsPlugin` — budget/bill reminders

Both are guarded by `Capacitor.isNativePlatform()`, so the app degrades safely in a
browser. Do not add plugins.

## Verification checklist

Before calling a rebuild done:

1. Open `out/index.html` and your build side by side. Every screen: Dashboard,
   Spaces, Invoices, Receipts, Analytics, Budgets, Subscriptions.
2. Toggle dark mode. Background goes to `#0E0E12`.
3. Trigger a toast and confirm it **does not animate**.
4. Count the Tailwind classes in your compiled CSS — should be the 53 above plus
   Tailwind's own preflight/base reset.
5. Confirm the launcher icon matches the black/white "F".
6. Confirm no network calls. The app is entirely offline.

## Known, unavoidable divergences

Accept these; they cannot be recovered from the APK:

- **Original file/folder structure, TypeScript types, and variable names are gone.**
  No source maps shipped. This is de-minified compiled output.
- **The original `tailwind.config.js` is unknown.** The one in the repo is minimal
  and sufficient for these 53 classes. Your theme extensions, if any, are lost.
- **A different Recharts minor may render charts a pixel differently.**
- **Gradle wrapper version, signing config, and CI are not recoverable.**

## If you have the original source

Use it. Anything recovered from an APK is a reconstruction. The real project files
are strictly better than this repository for every purpose except understanding what
actually shipped.
