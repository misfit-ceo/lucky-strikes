// agentMatchApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/agentMatchApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_AGENT_MATCH_URL || 'http://localhost:8082';

export const agentMatchApi = createApi({
  reducerPath: 'agentMatchApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    getAgents: builder.query<any, void>({
      query: () => '/api/agent-match/profiles',
    }),
    matchAgents: builder.mutation<any, { genre: string; experience: number }>({
      query: (preferences) => ({
        url: '/api/agent-match/match',
        method: 'POST',
        body: preferences,
      }),
    }),
  }),
});

export const { useGetAgentsQuery, useMatchAgentsMutation } = agentMatchApi;
