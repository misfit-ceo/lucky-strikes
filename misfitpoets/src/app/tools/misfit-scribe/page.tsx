// src/app/tools/misfit-scribe/page.tsx
"use client";

import React, { useState } from "react";
import ModeSwitch from "./components/ModeSwitch";
import Editor from "./components/Editor";
import AIResearchPanel from "./components/AIResearchPanel";

export default function MisfitScribePage() {
  // The current writing mode: novel, script, poetry, play
  const [mode, setMode] = useState<"novel" | "script" | "poetry" | "play">("novel");

  // If you want role-based gating, you could fetch this from context or a server:
  const userRole = "free"; // e.g., "free" or "premium"

  return (
    <section>
      <h2 className="text-xl font-bold mb-4">Misfit Scribe</h2>
      <p className="text-sm text-gray-700 mb-6">
        The AI-powered writing environment for novelists, scriptwriters, and poets—
        fueled by empathy, creative exploration, and the raw authenticity of Misfit Poets.
      </p>

      {/* Mode Switch for novel/script/poetry/play */}
      <div className="mb-4">
        <ModeSwitch mode={mode} setMode={setMode} />
      </div>

      <div className="flex flex-col sm:flex-row gap-6">
        {/* Main Editor Panel */}
        <Editor mode={mode} userRole={userRole} />

        {/* AI Research / Inspiration Panel */}
        <AIResearchPanel mode={mode} />
      </div>
    </section>
  );
}

