// src/components/Footer.tsx
"use client";

export default function Footer() {
  return (
    <footer className="bg-gray-200 mt-6">
      <div className="container mx-auto px-4 py-4 text-center text-sm text-gray-600">
        © {new Date().getFullYear()} MyBrand. All rights reserved.
      </div>
    </footer>
  );
}
