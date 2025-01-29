// src/app/tools/misfit-scribe/layout.tsx

import React from "react";

export const metadata = {
  title: "Misfit Scribe | Misfit Poets",
  description: "A next-gen AI writing tool from Misfit Poets.",
};

export default function MisfitScribeLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div className="bg-white text-black min-h-[80vh] p-4">
      {children}
    </div>
  );
}
