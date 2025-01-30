// src/app/tools/misfit-spark/layout.tsx

export default function SparkLayout({ children }: { children: React.ReactNode }) {
    // Minimal wrapper that doesn't override global Nav or Tools sub-nav
    return (
      <section className="p-4 min-h-screen bg-white">
        {children}
      </section>
    );
  }
  