// app/tools/misfit-canvas/[boardId]/page.tsx
"use client";

import { useState, useEffect, useRef } from "react";
import { useParams } from "next/navigation";
import io, { Socket } from "socket.io-client";

interface StickyNote {
  id: string;
  x: number;
  y: number;
  text: string;
}

export default function BoardPage() {
  const [notes, setNotes] = useState<StickyNote[]>([]);
  const socketRef = useRef<Socket | null>(null);
  const { boardId } = useParams() as { boardId: string };

  useEffect(() => {
    // Connect to socket server
    const socket = io("http://localhost:4000"); // Adjust to your server URL
    socketRef.current = socket;

    // Join a room for this board
    socket.emit("joinBoard", boardId);

    // Listen for incoming notes
    socket.on("notesUpdate", (updatedNotes: StickyNote[]) => {
      setNotes(updatedNotes);
    });

    return () => {
      socket.disconnect();
    };
  }, [boardId]);

  const addNote = () => {
    if (!socketRef.current) return;
    const newNote: StickyNote = {
      id: Date.now().toString(),
      x: Math.random() * 300,
      y: Math.random() * 300,
      text: "New idea here...",
    };
    socketRef.current.emit("addNote", newNote);
  };

  return (
    <div className="relative w-full h-[600px] bg-white border border-gray-300 rounded">
      <p className="text-gray-600 mb-3">
        Board: <strong>{boardId}</strong> (Collaborative space)
      </p>
      <button onClick={addNote} className="btn-brand mb-3">
        Add Sticky Note
      </button>
      <div className="w-full h-full relative">
        {notes.map((note) => (
          <div
            key={note.id}
            className="absolute w-32 h-32 bg-yellow-200 p-2 shadow rounded"
            style={{ top: note.y, left: note.x }}
          >
            <p>{note.text}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
