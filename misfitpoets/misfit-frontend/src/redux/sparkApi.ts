// sparkApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/sparkApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_SPARK_URL || 'http://localhost:8092';

export const sparkApi = createApi({
  reducerPath: 'sparkApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    generatePrompt: builder.mutation<any, { theme: string; tone: string }>({
      query: (body) => ({
        url: '/api/spark/generate',
        method: 'POST',
        body,
      }),
    }),
    getPrompts: builder.query<any, void>({
      query: () => '/api/spark/prompts',
    }),
    getPromptById: builder.query<any, number>({
      query: (id) => `/api/spark/prompts/${id}`,
    }),
    deletePrompt: builder.mutation<any, number>({
      query: (id) => ({
        url: `/api/spark/prompts/${id}`,
        method: 'DELETE',
      }),
    }),
  }),
});

export const { useGeneratePromptMutation, useGetPromptsQuery, useGetPromptByIdQuery, useDeletePromptMutation } = sparkApi;
