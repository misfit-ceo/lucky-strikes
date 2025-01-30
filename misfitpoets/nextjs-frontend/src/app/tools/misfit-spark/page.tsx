// src/app/tools/misfit-spark/page.tsx
"use client";

import { useState } from "react";

enum Genre {
  Poetry = "Poetry",
  Fiction = "Fiction",
  NonFiction = "Non-Fiction",
  Marketing = "Marketing",
}

enum Tone {
  Uplifting = "Uplifting",
  Mysterious = "Mysterious",
  Introspective = "Introspective",
  Humorous = "Humorous",
}

enum Complexity {
  Concise = "Concise (under 100 words)",
  Moderate = "Moderate (100-300 words)",
  Elaborate = "Elaborate (300+ words)",
}

export default function MisfitSparkPage() {
  const [genre, setGenre] = useState<Genre>(Genre.Poetry);
  const [tone, setTone] = useState<Tone>(Tone.Uplifting);
  const [complexity, setComplexity] = useState<Complexity>(Complexity.Concise);
  const [prompt, setPrompt] = useState("");
  const [loading, setLoading] = useState(false);

  // Example advanced param (like emotional theme or "creative constraint")
  const [keyword, setKeyword] = useState("");

  const handleGenerate = async () => {
    setLoading(true);
    setPrompt("");

    try {
      const res = await fetch("/tools/misfit-spark/api/generate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ genre, tone, complexity, keyword }),
      });
      const data = await res.json();
      setPrompt(data.prompt || "");
    } catch (error) {
      console.error("Prompt generation error:", error);
      setPrompt("Something went wrong. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="bg-gray-50 p-4 rounded shadow">
      <h1 className="text-2xl font-bold mb-4">Misfit Spark</h1>
      <p className="text-gray-700 mb-6 max-w-prose">
        Ignite your next idea—tune the parameters below, and let Spark 
        generate a prompt that respects your style, tone, and brand of 
        creativity.
      </p>

      {/* Form for advanced parameters */}
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-4 mb-4">
        {/* Genre */}
        <div>
          <label className="block text-gray-700 font-semibold mb-1">
            Genre
          </label>
          <select
            value={genre}
            onChange={(e) => setGenre(e.target.value as Genre)}
            className="w-full border border-gray-300 rounded p-2"
          >
            {Object.values(Genre).map((g) => (
              <option key={g} value={g}>
                {g}
              </option>
            ))}
          </select>
        </div>

        {/* Tone */}
        <div>
          <label className="block text-gray-700 font-semibold mb-1">
            Tone
          </label>
          <select
            value={tone}
            onChange={(e) => setTone(e.target.value as Tone)}
            className="w-full border border-gray-300 rounded p-2"
          >
            {Object.values(Tone).map((t) => (
              <option key={t} value={t}>
                {t}
              </option>
            ))}
          </select>
        </div>

        {/* Complexity */}
        <div>
          <label className="block text-gray-700 font-semibold mb-1">
            Complexity
          </label>
          <select
            value={complexity}
            onChange={(e) => setComplexity(e.target.value as Complexity)}
            className="w-full border border-gray-300 rounded p-2"
          >
            {Object.values(Complexity).map((c) => (
              <option key={c} value={c}>
                {c}
              </option>
            ))}
          </select>
        </div>

        {/* Keyword / Emotional Theme */}
        <div>
          <label className="block text-gray-700 font-semibold mb-1">
            Keyword / Emotional Theme (optional)
          </label>
          <input
            type="text"
            placeholder="e.g. 'hope', 'resilience'..."
            value={keyword}
            onChange={(e) => setKeyword(e.target.value)}
            className="w-full border border-gray-300 rounded p-2"
          />
        </div>
      </div>

      <button
        onClick={handleGenerate}
        disabled={loading}
        className="btn-brand"
      >
        {loading ? "Generating..." : "Generate Prompt"}
      </button>

      {/* Display generated prompt */}
      {prompt && (
        <div className="mt-6 bg-white p-4 rounded shadow">
          <h2 className="text-xl font-semibold mb-2 text-gray-800">
            Your Prompt
          </h2>
          <p className="text-gray-800">{prompt}</p>
        </div>
      )}
    </div>
  );
}
