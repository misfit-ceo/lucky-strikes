// src/app/library/components/SearchBar.tsx

interface SearchBarProps {
    searchTerm: string;
    setSearchTerm: (term: string) => void;
    onSearch: () => void;
  }
  
  export default function SearchBar({ searchTerm, setSearchTerm, onSearch }: SearchBarProps) {
    return (
      <div className="text-center mb-6">
        <input
          type="text"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          placeholder="Search books, poetry, or lyrics..."
          className="w-full max-w-lg px-4 py-2 border border-gray-300 rounded focus:outline-none"
        />
        <button
          onClick={onSearch}
          className="btn-brand ml-4" // Uses your gold brand button
          disabled={!searchTerm.trim()}
        >
          Search
        </button>
      </div>
    );
  }
  