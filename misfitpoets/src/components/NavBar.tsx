// src/components/NavBar.tsx
"use client";

import React, { useState } from "react";

export default function NavBar() {
  const [toolsOpen, setToolsOpen] = useState(false);

  return (
    <nav className="w-full bg-white shadow-md px-4 py-2 flex items-center justify-between">
      {/* Brand / Home Link */}
      <div className="text-xl font-bold">
        <a href="/" className="hover:text-blue-600">
          Misfit Poets
        </a>
      </div>

      {/* Nav Links */}
      <div className="flex items-center gap-6">
        <a href="/library" className="text-gray-700 hover:text-blue-600">
          Library
        </a>
        <a href="/blog" className="text-gray-700 hover:text-blue-600">
          Blog
        </a>
        <a href="/community" className="text-gray-700 hover:text-blue-600">
          Community
        </a>

        {/* Tools Dropdown */}
        <div className="relative">
          <button
            onClick={() => setToolsOpen(!toolsOpen)}
            className="text-gray-700 hover:text-blue-600"
          >
            Tools ▾
          </button>
          {toolsOpen && (
            <div className="absolute right-0 mt-2 w-44 bg-white border rounded shadow z-50">
              <ul className="py-1 text-sm text-gray-700">
                <li>
                  <a
                    href="/tools/misfit-scribe"
                    className="block px-4 py-2 hover:bg-gray-100"
                  >
                    Misfit Scribe
                  </a>
                </li>
                <li>
                  <a
                    href="/tools/misfit-flow"
                    className="block px-4 py-2 hover:bg-gray-100"
                  >
                    Misfit Flow
                  </a>
                </li>
              </ul>
            </div>
          )}
        </div>
      </div>
    </nav>
  );
}
