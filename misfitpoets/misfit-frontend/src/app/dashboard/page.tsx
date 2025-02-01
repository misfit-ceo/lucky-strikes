"use client";
import React from 'react';
import { useGetDashboardMetricsQuery } from '@/redux/api/dashboardApi';

export default function DashboardPage() {
  const { data: metrics, error, isLoading } = useGetDashboardMetricsQuery();

  if (isLoading) {
    return <div className="p-8">Loading dashboard data...</div>;
  }

  if (error) {
    return (
      <div className="p-8 text-red-500">
        Error loading dashboard data. {error.toString()}
      </div>
    );
  }

  return (
    <div className="container mx-auto p-8">
      <header className="mb-8">
        <h1 className="text-4xl font-bold">Dashboard</h1>
        <p className="mt-2 text-lg">
          Welcome to your MisfitPoets Dashboard. Here’s an overview of your account and key metrics.
        </p>
      </header>

      <section className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <div className="bg-white shadow rounded-lg p-6">
          <h2 className="text-2xl font-semibold mb-4">Key Metrics</h2>
          <div className="space-y-2">
            <p>
              <span className="font-bold">Manuscripts in Progress:</span> {metrics.inProgress}
            </p>
            <p>
              <span className="font-bold">Published Books:</span> {metrics.published}
            </p>
            <p>
              <span className="font-bold">Agent Matches:</span> {metrics.agentMatches}
            </p>
            <p>
              <span className="font-bold">Upcoming Tasks:</span> {metrics.upcomingTasks}
            </p>
          </div>
        </div>

        <div className="bg-white shadow rounded-lg p-6">
          <h2 className="text-2xl font-semibold mb-4">Notifications</h2>
          {metrics.notifications && metrics.notifications.length > 0 ? (
            <ul className="list-disc pl-5">
              {metrics.notifications.map((note: string, index: number) => (
                <li key={index}>{note}</li>
              ))}
            </ul>
          ) : (
            <p>No new notifications.</p>
          )}
        </div>
      </section>
    </div>
  );
}
