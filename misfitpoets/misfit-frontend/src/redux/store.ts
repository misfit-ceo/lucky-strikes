import { configureStore } from '@reduxjs/toolkit';
import { dashboardApi } from './api/dashboardApi';
// import other API slices and reducers as needed
import authReducer from './slices/authSlice';
import themeReducer from './slices/themeSlice';

export const store = configureStore({
  reducer: {
    [dashboardApi.reducerPath]: dashboardApi.reducer,
    auth: authReducer,
    theme: themeReducer,
    // ... add other reducers here
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(dashboardApi.middleware),
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
