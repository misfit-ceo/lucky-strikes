// src/app/blog/[slug]/page.tsx
interface BlogPostProps {
  params: {
    slug: string;
  };
}

export default function BlogPost({ params }: BlogPostProps) {
  return (
    <section>
      <h1 className="text-3xl font-semibold mb-3">
        Blog Post: {params.slug.replace("-", " ")}
      </h1>
      <p className="text-gray-700">
        This is a placeholder for the blog post with slug “{params.slug}”.
      </p>
    </section>
  );
}
