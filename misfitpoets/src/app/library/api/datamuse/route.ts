// app/library/api/datamuse/route.ts
import { NextRequest, NextResponse } from "next/server";
import axios from "axios";

export async function GET(request: NextRequest) {
  const { searchParams } = new URL(request.url);
  const ml = searchParams.get("ml");   // "means like"
  const rel_rhy = searchParams.get("rel_rhy"); // "rhymes"

  let queryString = "https://api.datamuse.com/words?";
  if (ml) queryString += `ml=${encodeURIComponent(ml)}&`;
  if (rel_rhy) queryString += `rel_rhy=${encodeURIComponent(rel_rhy)}&`;
  queryString += "max=20";

  try {
    const response = await axios.get(queryString);
    return NextResponse.json(response.data);
  } catch (err: any) {
    console.error("Datamuse route error:", err);
    return NextResponse.json({ error: err.message }, { status: 500 });
  }
}
