// src/app/tools/misfit-flow/[id]/page.tsx
import React from "react";

export default async function FlowProjectPage({
  params
}: {
  params: { id: string }
}) {
  const { id } = params;

  // In real usage, fetch project from DB
  const project = {
    id,
    title: `Project ${id}`,
    budget: 5000,
    allocated: 1200
  };

  return (
    <section>
      <h2 className="text-xl font-bold mb-2">Project: {project.title}</h2>
      <p className="text-sm text-gray-700 mb-4">
        Budget: ${project.budget} | Allocated: ${project.allocated}
      </p>
      <p>Here you can show deeper details or your BudgetBoard for this specific project.</p>
    </section>
  );
}