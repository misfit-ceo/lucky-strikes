// src/app/tools/misfit-scribe/[id]/page.tsx

import React from "react";

export default async function MisfitScribeDocumentPage({
  params,
}: {
  params: { id: string };
}) {
  const { id } = params;

  // In a real scenario: fetch user doc from DB or aggregator
  // Example:
  // const doc = await db.doc.findUnique({ where: { id } });
  // or fallback to "Doc not found"

  const doc = {
    id,
    title: `Document ${id}`,
    content: "Placeholder text for your long-form writing...",
    mode: "novel", // e.g., you might store the mode in DB
  };

  return (
    <section>
      <h2 className="text-xl font-bold mb-2">Misfit Scribe Document</h2>
      <p className="mb-4 text-gray-700">ID: {id}</p>

      <div className="border p-4 rounded">
        <h3 className="font-semibold mb-1">
          Title: {doc.title} <span className="ml-2 text-sm text-gray-500">({doc.mode})</span>
        </h3>
        <p>{doc.content}</p>
      </div>
    </section>
  );
}
