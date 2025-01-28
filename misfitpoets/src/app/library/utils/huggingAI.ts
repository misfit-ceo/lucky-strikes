// app/library/utils/huggingAI.ts
import fetch from "node-fetch";

const HF_API_URL = process.env.HF_EMBEDDING_API_URL || "https://api-inference.huggingface.co/models/your-model";
const HF_API_TOKEN = process.env.HF_API_TOKEN || "";

export async function generateEmbedding(text: string): Promise<number[] | null> {
  try {
    const response = await fetch(HF_API_URL, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${HF_API_TOKEN}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ inputs: text }),
    });
    if (!response.ok) {
      throw new Error(`Hugging Face error: ${response.statusText}`);
    }
    const data = await response.json();
    // Format depends on your model
    return data[0]?.embedding || null;
  } catch (error) {
    console.error("generateEmbedding error:", error);
    return null;
  }
}
