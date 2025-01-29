// src/app/tools/page.tsx
"use client";

import React from "react";

export default function ToolsPage() {
  return (
    <section className="p-4">
      <h2 className="text-2xl font-bold mb-4">Misfit Poets Tools</h2>
      <p className="text-gray-700 mb-6">
        Explore powerful AI-driven writing and project management tools,
        all built with empathy and the creative spirit of Misfit Poets.
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
            A next-gen writing environment for novelists, scriptwriters, and poets—
            fueled by empathy and raw authenticity.
          </p>
        </li>

        <li>
          <a
            href="/tools/misfit-flow"
            className="text-blue-600 underline font-semibold"
          >
            Misfit Flow
          </a>
          <p className="text-sm text-gray-500 ml-4">
            Plan, protect, and allocate—your all-in-one project management
            and budgeting tool, infused with the Misfit Poets ethos.
          </p>
        </li>
      </ul>
    </section>
  );
}