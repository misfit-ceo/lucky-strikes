import { configureStore } from '@reduxjs/toolkit';
import { dashboardApi } from './api/dashboardApi';
// ... import other slices if needed

export const store = configureStore({
  reducer: {
    [dashboardApi.reducerPath]: dashboardApi.reducer,
    // ... other reducers
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(dashboardApi.middleware),
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
