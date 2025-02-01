// agentMatchApi.ts
// Location: misfitpoets/misfitpoets-frontend/src/redux/api/agentMatchApi.ts
import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const agentMatchApi = createApi({
  reducerPath: 'agentMatchApi',
  baseQuery: fetchBaseQuery({
    baseUrl: 'https://api.misfitpoets.com',
    prepareHeaders: (headers, { getState }) => {
      // Optionally attach the auth token here:
      const token = (getState() as any).auth.token;
      if (token) headers.set('authorization', `Bearer ${token}`);
      return headers;
    },
  }),
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
