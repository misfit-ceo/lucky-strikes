// src/app/library/components/ResultsList.tsx

interface LibraryResult {
    title: string;
    description: string;
    source: string;
  }
  
  interface ResultsListProps {
    results: LibraryResult[];
  }
  
  export default function ResultsList({ results }: ResultsListProps) {
    if (!results || results.length === 0) {
      return <p className="text-center text-grayAccent">No results found.</p>;
    }
  
    return (
      <div className="space-y-4">
        {results.map((item, idx) => (
          <div key={idx} className="panel-brand">
            <h2 className="header-font text-xl mb-2">{item.title}</h2>
            <p className="text-grayAccent">{item.description}</p>
            <p className="text-sm text-gold mt-1">Source: {item.source}</p>
          </div>
        ))}
      </div>
    );
  }
  