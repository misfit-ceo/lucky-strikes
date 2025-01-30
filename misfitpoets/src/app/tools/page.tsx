"use client";

import Link from "next/link";

export default function ToolsOverview() {
  return (
    <section className="space-y-6">
      <h1 className="text-3xl font-bold mb-4">Misfit Poets Tools</h1>
      <p className="text-gray-600 mb-8 max-w-prose">
        Discover our suite of collaborative and AI-assisted tools—designed
        to empower your writing, creativity, and sense of community.
      </p>

      {/* Misfit Canvas */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Canvas</h2>
          <p className="text-gray-700 mb-2">
            A real-time whiteboard for brainstorming. Plot outlines, mind-maps, or 
            share sketches with your creative circle.
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
            Track your writing projects with ease. Outline tasks, set timelines, 
            and watch your progress bloom.
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
            A calm, distraction-free writing space with gentle AI suggestions. 
            Perfect for poems, stories, or entire manuscripts.
          </p>
          <Link
            href="/tools/misfit-scribe"
            className="inline-block text-blue-600 hover:underline"
          >
            Start Writing
          </Link>
        </div>
      </div>

      {/* Misfit Spark */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Spark</h2>
          <p className="text-gray-700 mb-2">
            A dynamic prompt generator that ignites fresh ideas. Tailor style, 
            tone, or complexity, and watch your inspiration unfold.
          </p>
          <Link
            href="/tools/misfit-spark"
            className="inline-block text-blue-600 hover:underline"
          >
            Spark a Prompt
          </Link>
        </div>
      </div>

      {/* Misfit Weave */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Weave</h2>
          <p className="text-gray-700 mb-2">
            A fluid mind-mapping tool that forms an organic web of connected ideas. 
            Capture complexities in a living tapestry.
          </p>
          <Link
            href="/tools/misfit-weave"
            className="inline-block text-blue-600 hover:underline"
          >
            Weave Your Ideas
          </Link>
        </div>
      </div>

      {/* Misfit Vault */}
      <div className="bg-gray-100 p-4 rounded shadow flex items-center justify-between">
        <div>
          <h2 className="text-xl font-semibold mb-2">Misfit Vault</h2>
          <p className="text-gray-700 mb-2">
            Securely store and convert your creative works. From DOCX to PDF, 
            audio transcriptions, and more—your words rest safe here.
          </p>
          <Link
            href="/tools/misfit-vault"
            className="inline-block text-blue-600 hover:underline"
          >
            Open Vault
          </Link>
        </div>
      </div>
    </section>
  );
}
