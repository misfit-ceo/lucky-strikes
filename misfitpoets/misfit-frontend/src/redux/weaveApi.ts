// weaveApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/weaveApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_WEAVE_URL || 'http://localhost:8093';

export const weaveApi = createApi({
  reducerPath: 'weaveApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    getWeaveNodes: builder.query<any, void>({
      query: () => '/api/weave/nodes',
    }),
    getWeaveNodeById: builder.query<any, number>({
      query: (id) => `/api/weave/nodes/${id}`,
    }),
    createWeaveNode: builder.mutation<any, { title: string; content: string }>({
      query: (node) => ({
        url: '/api/weave/nodes',
        method: 'POST',
        body: node,
      }),
    }),
    createWeaveLink: builder.mutation<any, { sourceId: number; targetId: number }>({
      query: ({ sourceId, targetId }) => ({
        url: `/api/weave/links/${sourceId}/${targetId}`,
        method: 'POST',
      }),
    }),
    deleteWeaveLink: builder.mutation<any, { sourceId: number; targetId: number }>({
      query: ({ sourceId, targetId }) => ({
        url: `/api/weave/links/${sourceId}/${targetId}`,
        method: 'DELETE',
      }),
    }),
  }),
});

export const { 
  useGetWeaveNodesQuery, 
  useGetWeaveNodeByIdQuery, 
  useCreateWeaveNodeMutation, 
  useCreateWeaveLinkMutation, 
  useDeleteWeaveLinkMutation 
} = weaveApi;
