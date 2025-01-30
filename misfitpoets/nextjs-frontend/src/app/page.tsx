// src/app/page.tsx
"use client";

import React from "react";

export default function HomePage() {
  return (
    <section className="p-4">
      <h1 className="text-3xl font-bold mb-4">Welcome to Misfit Poets</h1>
      <p className="text-gray-700 mb-6">
        Dive into an empathetic, collaborative environment where writers of all 
        backgrounds transform their raw emotions into art—fueled by supportive 
        community and AI-driven creativity.
      </p>
      <p>
        Explore our <a href="/library" className="underline text-blue-600">Library</a> 
        or check out our <a href="/tools" className="underline text-blue-600">Tools</a> 
        to begin your journey.
      </p>
    </section>
  );
}
