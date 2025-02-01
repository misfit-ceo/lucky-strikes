// blogApi.ts
// Location: misfitpoets/misfit-frontend/src/redux/api/blogApi.ts

import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

const baseUrl = process.env.NEXT_PUBLIC_BLOG_URL || 'http://localhost:8098';

export const blogApi = createApi({
  reducerPath: 'blogApi',
  baseQuery: fetchBaseQuery({ baseUrl }),
  endpoints: (builder) => ({
    getPosts: builder.query<any, void>({
      query: () => '/api/blog/posts',
    }),
    getPostById: builder.query<any, number>({
      query: (id) => `/api/blog/posts/${id}`,
    }),
    createPost: builder.mutation<any, { title: string; content: string; author: string }>({
      query: (body) => ({
        url: '/api/blog/posts',
        method: 'POST',
        body,
      }),
    }),
    updatePost: builder.mutation<any, { id: number; post: any }>({
      query: ({ id, post }) => ({
        url: `/api/blog/posts/${id}`,
        method: 'PUT',
        body: post,
      }),
    }),
    deletePost: builder.mutation<any, number>({
      query: (id) => ({
        url: `/api/blog/posts/${id}`,
        method: 'DELETE',
      }),
    }),
  }),
});

export const { 
  useGetPostsQuery, 
  useGetPostByIdQuery, 
  useCreatePostMutation, 
  useUpdatePostMutation, 
  useDeletePostMutation 
} = blogApi;
