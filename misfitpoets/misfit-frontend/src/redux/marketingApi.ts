// marketingApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/marketingApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_MARKETING_URL || 'http://localhost:8096';

export const marketingApi = createApi({
  reducerPath: 'marketingApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    trackReferral: builder.mutation<any, { referrerCode: string }>({
      query: (body) => ({
        url: '/api/marketing/referrals/track',
        method: 'POST',
        body,
      }),
    }),
    trackConversion: builder.mutation<any, { referrerCode: string }>({
      query: (body) => ({
        url: '/api/marketing/referrals/conversion',
        method: 'POST',
        body,
      }),
    }),
    getInfluencerStats: builder.query<any, string>({
      query: (referrerCode) => `/api/marketing/influencers/${referrerCode}/stats`,
    }),
  }),
});

export const { useTrackReferralMutation, useTrackConversionMutation, useGetInfluencerStatsQuery } = marketingApi;
