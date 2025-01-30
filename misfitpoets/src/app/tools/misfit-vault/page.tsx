// src/app/tools/misfit-vault/page.tsx
"use client";

import { useState } from "react";

interface VaultFile {
  id: string;
  name: string;
  size: number;
  type: string; // e.g. "docx", "pdf", "wav"...
  uploadedAt: Date;
}

export default function MisfitVaultPage() {
  const [files, setFiles] = useState<VaultFile[]>([]);

  // Minimal MVP method: "upload" is just simulated
  const handleFileUpload = (evt: React.ChangeEvent<HTMLInputElement>) => {
    if (!evt.target.files) return;
    const fileList = Array.from(evt.target.files);
    const newFiles = fileList.map((file) => {
      return {
        id: Date.now().toString() + Math.random().toString().slice(2),
        name: file.name,
        size: file.size,
        type: file.type || "unknown",
        uploadedAt: new Date(),
      };
    });
    setFiles((prev) => [...prev, ...newFiles]);
  };

  return (
    <div className="bg-gray-50 p-4 rounded shadow">
      <h1 className="text-2xl font-bold mb-2">Misfit Vault</h1>
      <p className="text-gray-700 mb-6 max-w-prose">
        Safeguard and transform your creative works with ease. Drop in
        manuscripts, poems, or recordings—Misfit Vault keeps them secure while 
        offering flexible format conversions (coming soon!).
      </p>

      {/* Basic file upload input */}
      <div className="mb-6">
        <label className="block text-gray-600 font-semibold mb-1">
          Upload Files
        </label>
        <input
          type="file"
          multiple
          onChange={handleFileUpload}
          className="block w-full text-sm text-gray-500 file:mr-4 file:py-2 file:px-4
                     file:rounded file:border-0 file:text-sm file:font-semibold
                     file:bg-blue-100 file:text-blue-700 hover:file:bg-blue-200"
        />
      </div>

      {/* Displaying uploaded files */}
      {files.length > 0 && (
        <div className="bg-white p-4 rounded shadow">
          <h2 className="text-xl font-semibold mb-3 text-gray-800">
            Stored Files
          </h2>
          <ul className="space-y-2">
            {files.map((f) => (
              <li
                key={f.id}
                className="flex items-center justify-between bg-gray-100 p-2 rounded"
              >
                <div>
                  <p className="font-medium text-gray-800">{f.name}</p>
                  <p className="text-sm text-gray-500">
                    {Math.round(f.size / 1024)} KB • {f.type}
                  </p>
                </div>
                <span className="text-xs text-gray-400">
                  {f.uploadedAt.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })}
                </span>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
}
