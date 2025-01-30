// src/app/tools/misfit-flow/components/BudgetBoard.tsx
"use client";

import React, { useState } from "react";

export default function BudgetBoard() {
  // Example default budget
  const [totalBudget, setTotalBudget] = useState(2000);
  // Track allocated funds or line items
  const [allocated, setAllocated] = useState(0);

  // Quick example function to allocate funds
  const allocateFunds = (amount: number) => {
    if (allocated + amount <= totalBudget) {
      setAllocated(allocated + amount);
    } else {
      alert("You don't have enough in your budget to allocate that amount.");
    }
  };

  // Example to update the total budget (for demonstration)
  const handleBudgetChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const newBudget = parseFloat(e.target.value) || 0;
    setTotalBudget(newBudget);
    // If allocated > newBudget, handle that scenario too
    if (allocated > newBudget) {
      alert("Allocated funds exceed the new total budget!");
    }
  };

  return (
    <div className="card border p-4 rounded shadow">
      <h3 className="font-bold mb-2">Budget Board</h3>
      <div className="mb-4">
        <label className="block text-sm font-medium text-gray-700 mb-1">
          Total Budget
        </label>
        <input
          type="number"
          className="border p-1 w-40"
          value={totalBudget}
          onChange={handleBudgetChange}
          step="0.01"
        />
      </div>

      <p className="text-sm mb-4">
        Allocated: <span className="font-semibold">${allocated}</span> /{" "}
        <span className="font-semibold">${totalBudget}</span>
      </p>

      <div className="flex gap-2">
        <button className="btn" onClick={() => allocateFunds(100)}>
          Allocate $100
        </button>
        <button className="btn" onClick={() => allocateFunds(250)}>
          Allocate $250
        </button>
      </div>
    </div>
  );
}