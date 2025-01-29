// src/components/ToolsSubNav.tsx
"use client";

import Link from "next/link";

export default function ToolsSubNav() {
  return (
    <nav className="bg-blue-100 shadow-md py-3 px-5 mb-6">
      <ul className="flex space-x-4 text-sm font-medium">
        <li>
          <Link href="/tools" className="hover:opacity-80">
            Overview
          </Link>
        </li>
        <li>
          <Link href="/tools/misfit-canvas" className="hover:opacity-80">
            Canvas
          </Link>
        </li>
        <li>
          <Link href="/tools/misfit-flow" className="hover:opacity-80">
            Flow
          </Link>
        </li>
        <li>
          <Link href="/tools/misfit-scribe" className="hover:opacity-80">
            Scribe
          </Link>
        </li>
        <li>
          <Link href="/tools/misfit-spark" className="hover:opacity-80">
            Spark
          </Link>
        </li>
        <li>
          <Link href="/tools/misfit-weave" className="hover:opacity-80">
            Weave
          </Link>
        </li>
      </ul>
    </nav>
  );
}
