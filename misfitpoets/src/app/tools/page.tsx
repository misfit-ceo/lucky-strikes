// src/app/tools/page.tsx
"use client";

import React from "react";

export default function ToolsPage() {
  return (
    <section className="p-4">
      <h2 className="text-2xl font-bold mb-4">Misfit Poets Tools</h2>
      <p className="text-gray-700 mb-6">
        Enhance your writing with AI assistance, structured organization, and supportive collaboration.
      </p>

      <ul className="space-y-4">
        <li>
          <a
            href="/tools/misfit-scribe"
            className="text-blue-600 underline font-semibold"
          >
            Misfit Scribe
          </a>
          <p className="text-sm text-gray-500 ml-4">
            A next-gen writing environment for novelists, scriptwriters, and poets—powered by empathy and raw authenticity.
          </p>
        </li>
        {/* If you remove AI Writer, that's it for now. Add other tools as needed. */}
      </ul>
    </section>
  );
}
