// src/components/Footer.tsx
"use client";

import React from "react";

export default function Footer() {
  return (
    <footer className="bg-gray-100 text-center text-xs text-gray-500 p-4 mt-4">
      © {new Date().getFullYear()} Misfit Poets. All rights reserved.
    </footer>
  );
}
