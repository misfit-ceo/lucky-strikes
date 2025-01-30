// app/library/components/SearchBar.tsx
"use client";

import React, { useState, ChangeEvent, FormEvent } from "react";

interface SearchBarProps {
  onSearch: (query: string) => void;
  placeholder?: string;
  defaultValue?: string;
}

export default function SearchBar({
  onSearch,
  placeholder = "Search...",
  defaultValue = "",
}: SearchBarProps) {
  const [query, setQuery] = useState(defaultValue);

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setQuery(e.target.value);
  };

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    if (query.trim()) {
      onSearch(query.trim());
    }
  };

  return (
    <form onSubmit={handleSubmit} className="flex gap-2 items-center">
      <input
        type="text"
        value={query}
        onChange={handleChange}
        placeholder={placeholder}
        className="border px-2 py-1"
      />
      <button type="submit" className="bg-blue-600 text-white px-3 py-1 rounded">
        Search
      </button>
    </form>
  );
}
