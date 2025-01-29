// app/blog/[slug]/page.tsx

import { notFound } from "next/navigation";

// Minimal mock data for demonstration
const mockPosts: Record<string, any> = {
  "healing-through-haikus": {
    title: "Healing Through Haikus",
    content: `
      <p>Writing short, structured verses can help channel complex emotions.
      Here is a sample haiku from our community:</p>
      <blockquote>
        "Shadows in my mind / Fade with each gentle heartbeat / Peace rewrites sorrow"
      </blockquote>
      <p>In just a few lines, you can find solace and creativity merged together.</p>
    `,
    author: "Misfit Poet",
  },
  "communal-poetry-night": {
    title: "Communal Poetry Night",
    content: `
      <p>Last Friday, we hosted an open mic for misfits of all backgrounds to share their pain and hope through spoken word.
      It was a night of tears, laughter, and collective healing.</p>
      <p>Join us next time and feel the warmth of creative togetherness!</p>
    `,
    author: "Community Circle",
  },
};

export default function BlogPostPage({ params }: { params: { slug: string } }) {
  const post = mockPosts[params.slug];
  if (!post) return notFound();

  return (
    <article className="space-y-4">
      <h1 className="text-3xl font-bold">{post.title}</h1>
      <p className="text-gray-500 text-sm">By {post.author}</p>
      <div
        className="text-gray-800 leading-relaxed"
        dangerouslySetInnerHTML={{ __html: post.content }}
      />
      {/* Add your brand's comment system or user reflections here */}
    </article>
  );
}
