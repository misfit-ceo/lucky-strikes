// src/app/library/components/Filters.tsx

interface FiltersProps {
    apiFilters: { [key: string]: boolean };
    setApiFilters: (filters: { [key: string]: boolean }) => void;
  }
  
  export default function Filters({ apiFilters, setApiFilters }: FiltersProps) {
    const handleToggle = (source: string) => {
      setApiFilters({ ...apiFilters, [source]: !apiFilters[source] });
    };
  
    return (
      <div className="flex justify-center space-x-4 mb-6">
        {Object.keys(apiFilters).map((source) => (
          <label key={source} className="flex items-center space-x-2">
            <input
              type="checkbox"
              checked={apiFilters[source]}
              onChange={() => handleToggle(source)}
              className="form-checkbox text-gold"
            />
            <span className="text-textPrimary capitalize">{source}</span>
          </label>
        ))}
      </div>
    );
  }
  