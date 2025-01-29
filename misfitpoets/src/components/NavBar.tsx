"use client";

import Link from "next/link";
import { useState } from "react";

export default function NavBar() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <nav className="bg-white text-gray-900 border-b border-gray-200">
      <div className="container mx-auto px-4 py-3 flex items-center justify-between">
        {/* Brand / Logo */}
        <Link href="/" className="text-xl font-bold hover:opacity-80">
          Misfit Poets
        </Link>

        {/* Hamburger for mobile */}
        <button
          className="block lg:hidden"
          onClick={() => setIsOpen(!isOpen)}
          aria-label="Toggle Menu"
        >
          <svg className="h-6 w-6 fill-current" viewBox="0 0 24 24">
            <path d="M4 5h16M4 12h16M4 19h16" />
          </svg>
        </button>

        {/* Desktop Menu */}
        <ul className="hidden lg:flex space-x-6 text-sm font-medium">
          <li>
            <Link href="/blog" className="hover:opacity-80">
              Blog
            </Link>
          </li>
          <li>
            <Link href="/library" className="hover:opacity-80">
              Library
            </Link>
          </li>
          {/* Tools Submenu */}
          <li className="relative group">
            <span className="hover:opacity-80 cursor-pointer">Tools</span>
            <ul className="absolute hidden group-hover:block bg-white border mt-2 rounded shadow-md text-sm min-w-[180px]">
              <li>
                <Link
                  href="/tools/misfit-canvas"
                  className="block px-4 py-2 hover:bg-gray-100"
                >
                  Misfit Canvas
                </Link>
              </li>
              <li>
                <Link
                  href="/tools/misfit-flow"
                  className="block px-4 py-2 hover:bg-gray-100"
                >
                  Misfit Flow
                </Link>
              </li>
              <li>
                <Link
                  href="/tools/misfit-scribe"
                  className="block px-4 py-2 hover:bg-gray-100"
                >
                  Misfit Scribe
                </Link>
              </li>
              <li>
                <Link
                  href="/tools/misfit-spark"
                  className="block px-4 py-2 hover:bg-gray-100"
                >
                  Misfit Spark
                </Link>
              </li>
              <li>
                <Link
                  href="/tools/misfit-weave"
                  className="block px-4 py-2 hover:bg-gray-100"
                >
                  Misfit Weave
                </Link>
              </li>
            </ul>
          </li>
          <li>
            <Link href="/about" className="hover:opacity-80">
              About
            </Link>
          </li>
        </ul>
      </div>

      {/* Mobile Menu */}
      {isOpen && (
        <div className="lg:hidden bg-white border-t border-gray-200">
          <ul className="flex flex-col space-y-2 p-4 text-sm font-medium">
            <li>
              <Link href="/blog" onClick={() => setIsOpen(false)}>
                Blog
              </Link>
            </li>
            <li>
              <Link href="/library" onClick={() => setIsOpen(false)}>
                Library
              </Link>
            </li>
            {/* Tools sublinks: direct for mobile */}
            <li>
              <Link href="/tools/misfit-canvas" onClick={() => setIsOpen(false)}>
                Misfit Canvas
              </Link>
            </li>
            <li>
              <Link href="/tools/misfit-flow" onClick={() => setIsOpen(false)}>
                Misfit Flow
              </Link>
            </li>
            <li>
              <Link href="/tools/misfit-scribe" onClick={() => setIsOpen(false)}>
                Misfit Scribe
              </Link>
            </li>
            <li>
              <Link href="/tools/misfit-spark" onClick={() => setIsOpen(false)}>
                Misfit Spark
              </Link>
            </li>
            <li>
              <Link href="/tools/misfit-weave" onClick={() => setIsOpen(false)}>
                Misfit Weave
              </Link>
            </li>
            <li>
              <Link href="/about" onClick={() => setIsOpen(false)}>
                About
              </Link>
            </li>
          </ul>
        </div>
      )}
    </nav>
  );
}
