// src/app/tools/misfit-weave/page.tsx
"use client";

import { useState } from "react";

// A basic node type for your "spiderweb" concept
interface WeaveNode {
  id: string;
  label: string;
  angle: number; // for a spiral-lattice approach
  radius: number;
}

export default function MisfitWeavePage() {
  // Start with a single "core" node at angle 0, radius 0
  const [nodes, setNodes] = useState<WeaveNode[]>([
    { id: "center", label: "Center Idea", angle: 0, radius: 0 },
  ]);

  // Minimal "spiral-lattice" approach
  const addNode = () => {
    const newId = Date.now().toString();

    // Example: next node angle is offset from the last node's angle by some delta
    const baseAngle = (nodes.length / 8) * Math.PI * 2; 
    // Spiral radius increments
    const newRadius = 50 + nodes.length * 30; 

    const newNode: WeaveNode = {
      id: newId,
      label: `Strand ${nodes.length}`,
      angle: baseAngle,
      radius: newRadius,
    };
    setNodes((prev) => [...prev, newNode]);
  };

  // Convert polar (angle, radius) to cartesian
  const centerX = 400;
  const centerY = 300;

  return (
    <div className="relative w-full h-[600px] bg-gray-50 overflow-hidden">
      <h1 className="text-2xl font-bold mb-2">
        Misfit Weave
      </h1>
      <p className="text-gray-700 mb-4">
        An “organic web” of ideas using a simplified spiral-lattice approach. 
        Click below to spin new strands.
      </p>

      <button onClick={addNode} className="btn-brand mb-4">
        Spin New Strand
      </button>

      <div className="w-full h-full relative border border-gray-300 rounded p-2">
        {nodes.map((node) => {
          const x = centerX + node.radius * Math.cos(node.angle);
          const y = centerY + node.radius * Math.sin(node.angle);

          return (
            <div
              key={node.id}
              className="absolute w-20 h-20 bg-pink-200 
                         flex items-center justify-center text-sm 
                         rounded-full shadow cursor-pointer"
              style={{
                left: x,
                top: y,
                transform: "translate(-50%, -50%)",
              }}
            >
              {node.label}
            </div>
          );
        })}

        {/* Optionally draw lines between nodes or center -> node if you want. 
            With a real spiral-lattice or force layout, you'd have a dynamic approach. */}
      </div>
    </div>
  );
}
