export default function Blog() {
    const posts = [
      { title: "How Poetry Heals", slug: "how-poetry-heals" },
      { title: "Creative Writing Tips", slug: "creative-writing-tips" },
    ];
  
    return (
      <section>
        <h1 className="text-3xl font-bold mb-4">Blog</h1>
        <ul className="space-y-4">
          {posts.map((post) => (
            <li key={post.slug}>
              <a href={`/blog/${post.slug}`} className="text-blue-600 hover:underline">
                {post.title}
              </a>
            </li>
          ))}
        </ul>
      </section>
    );
  }
  