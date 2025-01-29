// src/app/tools/misfit-flow/page.tsx
"use client";

import React from "react";
import BudgetBoard from "./components/BudgetBoard";
import ResourceAllocation from "./components/ResourceAllocation";
import IPManagement from "./components/IPManagement";

export default function MisfitFlowPage() {
  return (
    <section>
      <h2 className="text-xl font-bold mb-4">Misfit Flow</h2>
      <p className="text-sm text-gray-700 mb-6">
        Plan, Protect, and Allocate—Without Losing Your Spark. Manage budgeting, resource allocations,
        and IP considerations, all with the empathetic vibe of Misfit Poets.
      </p>

      <div className="flex flex-col gap-6">
        {/* AI or standard modules—placeholder components */}
        <BudgetBoard />
        <ResourceAllocation />
        <IPManagement />
      </div>
    </section>
  );
}