// aggregatorApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/aggregatorApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_AGGREGATOR_URL || 'http://localhost:8090';

export const aggregatorApi = createApi({
  reducerPath: 'aggregatorApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    fetchData: builder.mutation<any, { query: string }>({
      query: (body) => ({
        url: '/api/aggregator/fetch',
        method: 'POST',
        body,
      }),
    }),
    getAggregatedData: builder.query<any, void>({
      query: () => '/api/aggregator/records',
    }),
  }),
});

export const { useFetchDataMutation, useGetAggregatedDataQuery } = aggregatorApi;
