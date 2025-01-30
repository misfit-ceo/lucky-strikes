// app/library/layout.tsx
import React from "react";

export const metadata = {
  title: "Misfit Poets Library",
  description: "Explore books, poetry, lyrics, etc.",
};

export default function LibraryLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div style={{ minHeight: "100vh", background: "#fff" }}>
      {/* TODO: Insert a real header or Nav if you like */}
      <main style={{ maxWidth: "800px", margin: "0 auto", padding: "1rem" }}>
        {children}
      </main>
      {/* TODO: Insert a footer or brand styling */}
    </div>
  );
}
