"use client";

import React, { useState, useEffect } from "react";

interface EditorProps {
  mode: "novel" | "script" | "poetry" | "play";
  userRole?: string; // e.g. "free" | "premium" from Auth0 or session
}

export default function Editor({
  mode,
  userRole = "free",
}: EditorProps) {
  const [content, setContent] = useState("");

  useEffect(() => {
    if (userRole === "free") {
      console.log("Free user => limit advanced AI expansions, etc.");
      // For example, you can show an upgrade prompt or disable certain features
    }
  }, [userRole]);

  return (
    <div className="border p-4 w-full h-full rounded">
      <h3 className="font-bold mb-2">
        {mode.charAt(0).toUpperCase() + mode.slice(1)} Editor
      </h3>
      <textarea
        rows={8}
        className="w-full border p-2"
        value={content}
        onChange={(e) => setContent(e.target.value)}
        placeholder={`Draft your ${mode} here...`}
      />
    </div>
  );
}
