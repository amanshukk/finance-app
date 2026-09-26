/** @type {import('next').NextConfig} */
const nextConfig = {
  // Capacitor serves a static export from the device's web assets folder,
  // which capacitor.config.json declares as "out".
  output: "export",
  images: { unoptimized: true },
};

export default nextConfig;
