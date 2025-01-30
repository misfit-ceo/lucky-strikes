// app/library/components/ResultsList.tsx
"use client";

import React from "react";

interface Item {
  id: string;
  title: string;
  source?: string;
}

interface ResultsListProps {
  items: Item[];
}

export default function ResultsList({ items }: ResultsListProps) {
  if (!items || items.length === 0) {
    return <p>No results found.</p>;
  }

  return (
    <ul>
      {items.map((item) => (
        <li key={item.id} className="mb-2">
          <a href={`/library/${item.id}`} className="underline text-blue-600">
            {item.title}
          </a>
          {item.source && <span className="text-sm ml-2">({item.source})</span>}
        </li>
      ))}
    </ul>
  );
}
