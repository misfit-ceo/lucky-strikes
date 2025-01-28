// app/library/page.tsx
"use client";

import React, { useState } from "react";
import SearchBar from "./components/SearchBar";
import ResultsList from "./components/ResultsList";
import Filters from "./components/Filters";

export default function LibraryPage() {
  const [query, setQuery] = useState("");
  const [selectedFilters, setSelectedFilters] = useState<string[]>([]);
  const [results, setResults] = useState<any[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // onSearch from the SearchBar
  const handleSearch = async (q: string) => {
    setQuery(q);
    doSearch(q, selectedFilters);
  };

  // onChange from the Filters
  const handleFilterChange = (filters: string[]) => {
    setSelectedFilters(filters);
    doSearch(query, filters);
  };

  // consolidated search function
  async function doSearch(searchTerm: string, filters: string[]) {
    if (!searchTerm.trim()) return;
    setError("");
    setLoading(true);
    setResults([]);

    try {
      // We'll pass 'type' as a CSV string, like "classic,modern,lyrics"
      const typeQuery = filters.join(",");
      const url = `/library/api/search?query=${encodeURIComponent(searchTerm)}&type=${encodeURIComponent(typeQuery)}`;
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      setResults(data.results || []);
    } catch (err: any) {
      console.error("Search error:", err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <section>
      <h1 className="text-3xl font-bold mb-4">Misfit Poets Library</h1>

      {/* Search Bar */}
      <div className="mb-4">
        <SearchBar
          placeholder="Search Misfit Poets resources..."
          onSearch={handleSearch}
        />
      </div>

      {/* Filters */}
      <div className="mb-4">
        <Filters
          sources={["classic", "modern", "lyrics"]}
          selectedSources={selectedFilters}
          setSelectedSources={handleFilterChange}
        />
      </div>

      {/* Error or loading */}
      {error && <p className="text-red-500">{error}</p>}
      {loading && <p>Loading...</p>}

      {/* Results */}
      <ResultsList items={results} />
    </section>
  );
}
