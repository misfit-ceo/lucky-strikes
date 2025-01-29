// src/app/api/canvasServer.ts
import { NextApiRequest } from "next";
import { Server as SocketIOServer } from "socket.io";
import { Server as HTTPServer } from "http";
import { NextApiResponseServerIO } from "@/types/NextApiResponseServerIO";
// A custom type that extends NextApiResponse with a .socket.server.io

// Simple in-memory store (replace with DB in production)
interface StickyNote {
  id: string;
  x: number;
  y: number;
  text: string;
}

let notes: StickyNote[] = [];

export const config = {
  api: {
    bodyParser: false, // We don't want Next to parse request body
  },
};

export default function handler(req: NextApiRequest, res: NextApiResponseServerIO) {
  if (!res.socket.server.io) {
    console.log("First use, starting socket.io...");

    // Convert Node's net.Server -> http.Server
    const httpServer: HTTPServer = res.socket.server as any;

    // Create new Socket.io server
    const io = new SocketIOServer(httpServer, {
      path: "/api/canvasServer",
      addTrailingSlash: false,
      cors: {
        origin: "*",
      },
    });

    io.on("connection", (socket) => {
      console.log("User connected to canvasServer.");

      // Example channel "joinBoard"
      socket.on("joinBoard", (boardId: string) => {
        socket.join(boardId);
        socket.emit("notesUpdate", notes);
      });

      // Example "addNote"
      socket.on("addNote", (newNote: StickyNote) => {
        notes.push(newNote);
        io.emit("notesUpdate", notes);
      });

      socket.on("disconnect", () => {
        console.log("User disconnected");
      });
    });

    // Attach to res
    res.socket.server.io = io;
  } else {
    console.log("Socket.io server already running.");
  }

  res.end();
}