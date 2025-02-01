// dashboardApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/dashboardApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_DASHBOARD_URL || 'http://localhost:8100';

export const dashboardApi = createApi({
  reducerPath: 'dashboardApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    getDashboardMetrics: builder.query<any, void>({
      query: () => '/api/dashboard/metrics',
    }),
  }),
});

export const { useGetDashboardMetricsQuery } = dashboardApi;
