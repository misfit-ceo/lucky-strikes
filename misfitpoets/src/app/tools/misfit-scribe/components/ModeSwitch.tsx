// src/app/tools/misfit-scribe/components/ModeSwitch.tsx
"use client";

import React from "react";

interface ModeSwitchProps {
  mode: "novel" | "script" | "poetry" | "play";
  setMode: (m: "novel" | "script" | "poetry" | "play") => void;
}

export default function ModeSwitch({ mode, setMode }: ModeSwitchProps) {
  const modes = ["novel", "script", "poetry", "play"];

  return (
    <div className="flex gap-2">
      {modes.map((m) => (
        <button
          key={m}
          onClick={() => setMode(m as any)}
          className={`px-3 py-1 rounded ${
            mode === m ? "bg-blue-600 text-white" : "bg-gray-200 text-gray-800"
          }`}
        >
          {m.charAt(0).toUpperCase() + m.slice(1)}
        </button>
      ))}
    </div>
  );
}
