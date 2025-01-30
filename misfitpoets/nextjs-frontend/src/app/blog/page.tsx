// app/blog/page.tsx
"use client";

import Link from "next/link";

// Minimal static data for demonstration (replace with real DB/API calls)
const examplePosts = [
  {
    slug: "healing-through-haikus",
    title: "Healing Through Haikus",
    excerpt: "Transform your pain into short, structured art forms.",
    category: "Resilience & Growth",
  },
  {
    slug: "communal-poetry-night",
    title: "Communal Poetry Night",
    excerpt: "How misfits shared stories and found unity in spoken words.",
    category: "Community Spotlight",
  },
];

export default function BlogListing() {
  return (
    <section>
      <h1 className="text-4xl font-bold mb-6">Misfit Poets Blog</h1>
      <p className="text-gray-700 mb-8">
        Stories, tips, and reflections to heal through creativity.
      </p>

      <div className="space-y-6">
        {examplePosts.map((post) => (
          <div key={post.slug} className="bg-gray-100 p-4 rounded shadow">
            <h2 className="text-xl font-semibold mb-2">{post.title}</h2>
            <p className="text-gray-600 mb-2">{post.excerpt}</p>
            <span className="block text-sm text-gray-500 mb-2">
              Category: {post.category}
            </span>
            <Link
              href={`/blog/${post.slug}`}
              className="text-blue-600 hover:underline"
            >
              Read More
            </Link>
          </div>
        ))}
      </div>
    </section>
  );
}
