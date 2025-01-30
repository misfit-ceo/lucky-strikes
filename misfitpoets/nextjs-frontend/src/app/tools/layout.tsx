// src/app/tools/layout.tsx
import ToolsSubNav from "@/components/ToolsSubNav";
import type { Metadata } from "next";

export const metadata: Metadata = {
  title: "Misfit Poets - Tools",
  description: "Explore and innovate with our creative toolset.",
};

export default function ToolsLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <section className="bg-gray-50 min-h-screen">
      {/* Secondary Nav for Tools only */}
      <ToolsSubNav />
      {/* Tools content area */}
      <div className="container mx-auto px-4 py-6">{children}</div>
    </section>
  );
}
