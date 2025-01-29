// src/app/tools/page.tsx
"use client";

import Link from "next/link";

export default function ToolsOverview() {
  return (
    <section className="space-y-6">
      <h1 className="text-3xl font-bold mb-4">Tools</h1>
      <p className="text-gray-600 mb-8">
        Explore our suite of creative tools designed to inspire and empower your
        writing journey—from brainstorming to final edits.
      </p>

      {/* Misfit Canvas */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Canvas</h2>
          <p className="text-gray-700 mb-2">
            A real-time whiteboard for collaborative idea mapping, perfect for
            story arcs or group poetry sessions.
          </p>
          <Link
            href="/tools/misfit-canvas"
            className="inline-block text-blue-600 hover:underline"
          >
            Launch Canvas
          </Link>
        </div>
      </div>

      {/* Misfit Flow */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Flow</h2>
          <p className="text-gray-700 mb-2">
            Keep track of your writing process—outline scenes, track progress,
            and stay inspired at every step.
          </p>
          <Link
            href="/tools/misfit-flow"
            className="inline-block text-blue-600 hover:underline"
          >
            Open Flow
          </Link>
        </div>
      </div>

      {/* Misfit Scribe */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Scribe</h2>
          <p className="text-gray-700 mb-2">
            A dedicated writing environment with gentle AI suggestions—draft
            poems, short stories, or novels with calm focus.
          </p>
          <Link
            href="/tools/misfit-scribe"
            className="inline-block text-blue-600 hover:underline"
          >
            Start Writing
          </Link>
        </div>
      </div>
    </section>
  );
}
