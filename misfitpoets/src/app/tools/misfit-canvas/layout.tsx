/ app/tools/misfit-canvas/layout.tsx

import Header from "@/components/Header";
import Footer from "@/components/Footer";

export const metadata = {
  title: "Misfit Canvas",
  description: "Real-time collaborative whiteboard for Misfit Poets",
};

export default function CanvasLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-white min-h-screen flex flex-col">
      <Header />
      <main className="container mx-auto px-6 py-8 flex-grow">
        {children}
      </main>
      <Footer />
    </div>
  );
}