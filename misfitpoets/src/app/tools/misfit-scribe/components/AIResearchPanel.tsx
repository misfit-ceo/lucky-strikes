// src/app/tools/misfit-scribe/components/AIResearchPanel.tsx
"use client";

import React, { useState } from "react";

interface AIResearchPanelProps {
  mode: "novel" | "script" | "poetry" | "play";
}

export default function AIResearchPanel({ mode }: AIResearchPanelProps) {
  const [query, setQuery] = useState("");
  const [results, setResults] = useState<string[]>([]);

  const handleSearch = async () => {
    // placeholder: call aggregator or suggestions route
    setResults([`[Stub result for '${query}' in ${mode} mode]`]);
  };

  return (
    <div className="border w-60 p-4 rounded flex-shrink-0">
      <h3 className="font-bold mb-2">AI Research</h3>
      <input
        type="text"
        value={query}
        onChange={(e) => setQuery(e.target.value)}
        className="border mb-2 p-1 w-full"
        placeholder="Topic or keyword..."
      />
      <button
        onClick={handleSearch}
        className="bg-blue-600 text-white w-full py-1 rounded"
      >
        Search
      </button>

      <ul className="mt-2 text-sm">
        {results.map((res, idx) => (
          <li key={idx}>- {res}</li>
        ))}
      </ul>
    </div>
  );
}
