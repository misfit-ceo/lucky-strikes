// app/tools/misfit-canvas/page.tsx
"use client";

import Link from "next/link";

const mockBoards = [
  { id: "brainstorm1", title: "Brainstorm: Scene One" },
  { id: "characterMap", title: "Character Relationship Map" },
];

export default function CanvasHome() {
  return (
    <section>
      <h1 className="text-3xl font-bold mb-4">Misfit Canvas</h1>
      <p className="text-gray-700 mb-6">
        Collaborate, brainstorm, and visualize your writing ideas in real time.
      </p>

      <div className="space-y-4">
        {mockBoards.map((board) => (
          <div
            key={board.id}
            className="bg-gray-100 p-4 rounded shadow flex justify-between items-center"
          >
            <h2 className="text-xl font-semibold">{board.title}</h2>
            <Link
              href={`/tools/misfit-canvas/${board.id}`}
              className="text-blue-600 hover:underline"
            >
              Open Board
            </Link>
          </div>
        ))}
      </div>
    </section>
  );
}
