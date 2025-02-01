// flowApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/flowApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_FLOW_URL || 'http://localhost:8091';

export const flowApi = createApi({
  reducerPath: 'flowApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    getTasks: builder.query<any, void>({
      query: () => '/api/flow/tasks',
    }),
    createTask: builder.mutation<any, { title: string; description: string; status: string }>({
      query: (task) => ({
        url: '/api/flow/tasks',
        method: 'POST',
        body: task,
      }),
    }),
    updateTask: builder.mutation<any, { id: number; task: any }>({
      query: ({ id, task }) => ({
        url: `/api/flow/tasks/${id}`,
        method: 'PUT',
        body: task,
      }),
    }),
    deleteTask: builder.mutation<any, number>({
      query: (id) => ({
        url: `/api/flow/tasks/${id}`,
        method: 'DELETE',
      }),
    }),
  }),
});

export const { useGetTasksQuery, useCreateTaskMutation, useUpdateTaskMutation, useDeleteTaskMutation } = flowApi;
