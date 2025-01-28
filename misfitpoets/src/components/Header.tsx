// src/components/Header.tsx
"use client";

import Link from "next/link";

export default function Header() {
  return (
    <header className="bg-gray-200 shadow">
      <nav className="container mx-auto px-4 py-3 flex items-center justify-between">
        <Link href="/" className="text-xl font-bold hover:opacity-80">
          MyBrand
        </Link>

        <ul className="flex space-x-6 text-sm">
          <li>
            <Link href="/about" className="hover:opacity-80">
              About
            </Link>
          </li>
          <li>
            <Link href="/library" className="hover:opacity-80">
              Library
            </Link>
          </li>
          <li>
            <Link href="/blog" className="hover:opacity-80">
              Blog
            </Link>
          </li>
          <li>
            <Link href="/tools" className="hover:opacity-80">
              Tools
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
