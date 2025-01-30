// app/blog/layout.tsx
import Header from "@/components/Header";
import Footer from "@/components/Footer";

export const metadata = {
  title: "Misfit Poets Blog",
  description: "Healing and creativity, one story at a time.",
};

export default function BlogLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div className="min-h-screen flex flex-col bg-white text-gray-900">
      <Header />
      <main className="container mx-auto px-6 py-8 flex-grow">
        {children}
      </main>
      <Footer />
    </div>
  );
}