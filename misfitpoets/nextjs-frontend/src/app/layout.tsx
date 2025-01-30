// src/app/layout.tsx
import React from "react";
import NavBar from "../components/NavBar";
import Footer from "../components/Footer";
import "./globals.css";

export const metadata = {
  title: "Misfit Poets",
  description: "A supportive, AI-driven creative community for authors and poets.",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className="bg-gray-50 text-gray-900 min-h-screen flex flex-col">
        <NavBar />
        <main className="flex-grow container mx-auto p-4">{children}</main>
        <Footer />
      </body>
    </html>
  );
}
