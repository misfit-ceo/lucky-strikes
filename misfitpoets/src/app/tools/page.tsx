"use client";

import Link from "next/link";

export default function ToolsOverviewPage() {
  return (
    <section className="space-y-6">
      <h1 className="text-3xl font-bold mb-4">Tools Overview</h1>
      <p className="text-gray-600 mb-8 max-w-prose">
        Explore our collaborative and AI-assisted tools—each designed to
        nurture your writing and brainstorming in a warm, inclusive space.
      </p>

      {/* Example tool card */}
      <div className="bg-gray-100 p-4 rounded shadow">
        <h2 className="text-xl font-semibold mb-2">Misfit Canvas</h2>
        <p className="text-gray-700 mb-2">
          A real-time whiteboard for group brainstorming—plot outlines,
          mind-maps, or share sketches with your creative circle.
        </p>
        <Link
          href="/tools/misfit-canvas"
          className="inline-block text-blue-600 hover:underline"
        >
          Launch Canvas
        </Link>
      </div>

      {/* ... repeat for Flow, Scribe, Spark, Weave ... */}
    </section>
  );
}

