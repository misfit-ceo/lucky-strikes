// src/app/blog/page.tsx

// Sample blog posts array for placeholders
const posts = [
  { title: "First Post", slug: "first-post" },
  { title: "Second Post", slug: "second-post" },
];

export default function Blog() {
  return (
    <section>
      <h1 className="text-2xl font-semibold mb-3">Blog</h1>
      <ul className="space-y-4">
        {posts.map((post) => (
          <li key={post.slug} className="card">
            <a href={`/blog/${post.slug}`}>
              <h2 className="text-xl font-bold">{post.title}</h2>
              <p className="text-gray-600">Read more about {post.title}...</p>
            </a>
          </li>
        ))}
      </ul>
    </section>
  );
}
