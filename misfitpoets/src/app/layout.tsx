import "./globals.css";
import type { Metadata } from "next";
import Link from "next/link";
import Image from "next/image";

export const metadata: Metadata = {
  title: "Misfit Poets",
  description: "A platform for outcasts, creators, and dreamers.",
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <body className="min-h-screen bg-white text-gray-900 antialiased">
        <header className="w-full px-4 py-2 bg-gray-100 shadow">
          <nav className="container mx-auto flex justify-between items-center">
            <Link href="/" className="flex items-center gap-2">
              <Image
                src="/logo.png"
                alt="Misfit Poets Logo"
                width={150}
                height={50}
                priority
              />
            </Link>
            <ul className="flex gap-6">
              <li><Link href="/about" className="hover:text-blue-600">About</Link></li>
              <li><Link href="/library" className="hover:text-blue-600">Library</Link></li>
              <li><Link href="/blog" className="hover:text-blue-600">Blog</Link></li>
              <li><Link href="/tools" className="hover:text-blue-600">Tools</Link></li>
            </ul>
          </nav>
        </header>
        <main className="container mx-auto px-4 mt-6">{children}</main>
        <footer className="mt-10 text-center text-sm text-gray-600 py-4">
          © {new Date().getFullYear()} Misfit Poets. All rights reserved.
        </footer>
      </body>
    </html>
  );
}
