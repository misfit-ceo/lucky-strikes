// src/redux/api/coversApi.ts
import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_COVERS_URL || 'http://localhost:8094';

export const coversApi = createApi({
  reducerPath: 'coversApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    requestCover: builder.mutation<any, { bookTitle: string; genre: string }>({
      query: (body) => ({
        url: '/api/covers/request',
        method: 'POST',
        body,
      }),
    }),
    getCovers: builder.query<any, void>({
      query: () => '/api/covers',
    }),
  }),
});

export const { useRequestCoverMutation, useGetCoversQuery } = coversApi;
