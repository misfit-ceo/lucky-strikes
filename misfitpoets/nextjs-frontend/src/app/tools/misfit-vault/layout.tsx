// src/app/tools/misfit-vault/layout.tsx

export default function VaultLayout({ children }: { children: React.ReactNode }) {
    // Minimal: No custom header/footer, so the global layout & Tools sub-nav remain.
    return (
      <section className="p-4 min-h-screen bg-white">
        {children}
      </section>
    );
  }
  