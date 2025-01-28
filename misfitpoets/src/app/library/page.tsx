// src/app/library/page.tsx
"use client";

import { useState } from "react";
import SearchBar from "./components/SearchBar";
import Filters from "./components/Filters";
import ResultsList from "./components/ResultsList";
import { fetchLibraryData } from "./api/fetchLibraryData";

export default function LibraryPage() {
  const [searchTerm, setSearchTerm] = useState("");
  const [apiFilters, setApiFilters] = useState({
    gutenberg: true,
    googleBooks: false,
    openLibrary: false,
    genius: false,
  });
  const [results, setResults] = useState<any[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSearch = async () => {
    setLoading(true);
    setError("");
    setResults([]);

    try {
      // fetch data from our stub
      const data = await fetchLibraryData(searchTerm, apiFilters);
      setResults(data);
    } catch (err) {
      console.error(err);
      setError("Something went wrong. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <section>
      <h1 className="text-4xl font-header text-gold mb-6 text-center">
        Explore the Library
      </h1>

      <SearchBar
        searchTerm={searchTerm}
        setSearchTerm={setSearchTerm}
        onSearch={handleSearch}
      />

      <Filters apiFilters={apiFilters} setApiFilters={setApiFilters} />

      {loading && <p className="text-center text-grayAccent">Loading...</p>}
      {error && <p className="text-red-500 mt-4 text-center">{error}</p>}

      {!loading && !error && <ResultsList results={results} />}
    </section>
  );
}
