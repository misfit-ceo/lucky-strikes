// app/library/api/genius/route.ts
import { NextRequest, NextResponse } from "next/server";
import axios from "axios";

const GENIUS_ACCESS_TOKEN = process.env.GENIUS_ACCESS_TOKEN || "";

export async function GET(request: NextRequest) {
  const { searchParams } = new URL(request.url);
  const q = searchParams.get("q") || "";

  if (!q) {
    return NextResponse.json({ error: "No 'q' param" }, { status: 400 });
  }

  try {
    const url = `https://api.genius.com/search?q=${encodeURIComponent(q)}`;
    const headers = {
      Authorization: `Bearer ${GENIUS_ACCESS_TOKEN}`,
    };
    const response = await axios.get(url, { headers });
    return NextResponse.json(response.data);
  } catch (err: any) {
    console.error("Genius route error:", err);
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}
