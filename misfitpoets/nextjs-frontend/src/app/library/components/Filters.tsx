// app/library/components/Filters.tsx
"use client";

import React from "react";

interface FiltersProps {
  sources: string[]; // e.g. ["gutenberg", "googleBooks", "genius"]
  selectedSources: string[];
  setSelectedSources: (newSources: string[]) => void;
}

export default function Filters({
  sources,
  selectedSources,
  setSelectedSources,
}: FiltersProps) {
  const handleToggle = (src: string) => {
    if (selectedSources.includes(src)) {
      setSelectedSources(selectedSources.filter((s) => s !== src));
    } else {
      setSelectedSources([...selectedSources, src]);
    }
  };

  return (
    <div className="flex gap-4">
      {sources.map((src) => (
        <label key={src} className="flex items-center gap-1">
          <input
            type="checkbox"
            checked={selectedSources.includes(src)}
            onChange={() => handleToggle(src)}
          />
          {src}
        </label>
      ))}
    </div>
  );
}
