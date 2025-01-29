// src/app/tools/misfit-flow/layout.tsx

import React from "react";

export const metadata = {
  title: "Misfit Flow | Misfit Poets",
  description: "Plan, Protect, and Allocate—Without Losing Your Spark.",
};

export default function MisfitFlowLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-white text-black min-h-[80vh] p-4">
      {children}
    </div>
  );
}