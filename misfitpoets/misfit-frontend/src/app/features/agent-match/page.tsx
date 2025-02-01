// page.tsx
// Location: misfitpoets/misfitpoets-frontend/src/app/features/agent-match/page.tsx
import { useGetAgentsQuery, useMatchAgentsMutation } from '../../../redux/api/agentMatchApi';

export default function AgentMatchPage() {
  const { data: agents, error } = useGetAgentsQuery();
  const [matchAgents] = useMatchAgentsMutation();

  const handleMatch = async () => {
    // Example preferences; in a real app, these would be collected from a form.
    const preferences = { genre: 'Fantasy', experience: 5 };
    await matchAgents(preferences);
  };

  return (
    <div className="p-8">
      <h2 className="text-3xl font-bold">Find Your Literary Agent</h2>
      <button onClick={handleMatch} className="bg-green-600 text-white py-2 px-4 rounded mt-4">
        Match Me with an Agent
      </button>
      {error && <p className="mt-4 text-red-500">Error loading agent profiles.</p>}
      {agents && (
        <ul className="mt-4">
          {agents.map((agent: any) => (
            <li key={agent.id}>{agent.name} – {agent.specialty}</li>
          ))}
        </ul>
      )}
    </div>
  );
}

