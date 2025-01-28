// src/app/library/layout.tsx
import type { Metadata } from "next";
import Header from "@/components/Header";  // Adjust path as needed
import Footer from "@/components/Footer";  // Adjust path as needed

export const metadata: Metadata = {
  title: "Misfit Poets Library",
  description: "Explore books, poetry, lyrics, and more.",
};

export default function LibraryLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-background text-textPrimary min-h-screen flex flex-col">
      <Header />
      <main className="container mx-auto px-6 py-8 flex-grow">
        {children}
      </main>
      <Footer />
    </div>
  );
}
