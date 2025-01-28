// app/library/components/AIHighlightTool.tsx
"use client";

import React, { useState } from "react";

export default function AIHighlightTool() {
  const [selectedText, setSelectedText] = useState("");
  const [suggestions, setSuggestions] = useState<string[]>([]);

  // Example: call your Datamuse route
  async function fetchSuggestions() {
    if (!selectedText) return;
    try {
      const res = await fetch(`/library/api/datamuse?ml=${encodeURIComponent(selectedText)}`);
      const data = await res.json();
      setSuggestions(data.map((d: any) => d.word));
    } catch (error) {
      console.error("Datamuse error:", error);
    }
  }

  return (
    <div>
      <h3>AIHighlightTool (MVP placeholder)</h3>
      <input
        type="text"
        placeholder="Select or type a word..."
        value={selectedText}
        onChange={(e) => setSelectedText(e.target.value)}
        className="border px-2 py-1"
      />
      <button onClick={fetchSuggestions} className="bg-blue-600 text-white px-2 py-1 ml-2">
        Get Suggestions
      </button>

      <ul className="mt-2">
        {suggestions.map((s, idx) => (
          <li key={idx}>{s}</li>
        ))}
      </ul>
    </div>
  );
}
