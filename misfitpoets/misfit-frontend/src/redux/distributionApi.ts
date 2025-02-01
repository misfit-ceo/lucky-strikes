// distributionApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/distributionApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_DISTRIBUTION_URL || 'http://localhost:8095';

export const distributionApi = createApi({
  reducerPath: 'distributionApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    submitTask: builder.mutation<any, { bookTitle: string; author: string; platform: string }>({
      query: (body) => ({
        url: '/api/distribution/request',
        method: 'POST',
        body,
      }),
    }),
    startTask: builder.mutation<any, number>({
      query: (id) => ({
        url: `/api/distribution/tasks/${id}/start`,
        method: 'POST',
      }),
    }),
    getDistributionTasks: builder.query<any, void>({
      query: () => '/api/distribution/tasks',
    }),
  }),
});

export const { useSubmitTaskMutation, useStartTaskMutation, useGetDistributionTasksQuery } = distributionApi;
