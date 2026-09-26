/**
 * Root layout. RECONSTRUCTED from the app's build output: the compiled
 * layout chunk (app__layout-af9206e1681d8863.js) contains no component body,
 * and the RSC payload in out/index.txt carries the metadata below.
 */
import "./globals.css";

export const metadata = {
  title: "Fintech App",
  description: "Finance dashboard",
};

export const viewport = {
  width: "device-width",
  initialScale: 1,
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
