// src/app/tools/misfit-weave/layout.tsx

export default function WeaveLayout({ children }: { children: React.ReactNode }) {
    // Minimal layout that doesn't override global header/footer or Tools sub-nav
    // Just a simple wrapper for brand styling if needed
    return (
      <section className="p-4 min-h-screen bg-white">
        {children}
      </section>
    );
  }
  