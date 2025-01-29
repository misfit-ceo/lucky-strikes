// src/app/tools/misfit-weave/api/weave/route.ts
import { NextRequest, NextResponse } from "next/server";

// For an enterprise approach, you'd store data in a DB or cache.
// We'll do a naive in-memory approach here:
let weaveNodes: any[] = [];

export async function GET() {
  return NextResponse.json({ nodes: weaveNodes });
}

export async function POST(req: NextRequest) {
  try {
    const body = await req.json();
    if (Array.isArray(body.nodes)) {
      weaveNodes = body.nodes;
      return NextResponse.json({ status: "ok", count: weaveNodes.length });
    }
    return NextResponse.json({ error: "Invalid data format" }, { status: 400 });
  } catch (err) {
    return NextResponse.json({ error: "Failed to parse request" }, { status: 500 });
  }
}

