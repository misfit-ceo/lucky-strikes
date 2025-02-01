// index.ts
// Location: misfitpoets/misfit-frontend/src/redux/index.ts

// Export the Redux store configuration.
export { store } from './store';

// Export typed hooks for use throughout the app.
export * from './hooks';

// Optionally, re-export all RTK Query API slices for easier imports.
export * from './api/dashboardApi';
export * from './api/agentMatchApi';
export * from './api/aggregatorApi';
export * from './api/flowApi';
export * from './api/sparkApi';
export * from './api/weaveApi';
export * from './api/coversApi';
export * from './api/distributionApi';
export * from './api/blogApi';
export * from './api/marketingApi';

// Re-export any feature slices if needed.
export * from './slices/authSlice';
export * from './slices/themeSlice';
export * from './slices/notificationSlice';
