export default function BlogPost({ params }: { params: { slug: string } }) {
    return (
      <section>
        <h1 className="text-3xl font-bold mb-4">Blog Post: {params.slug.replace("-", " ")}</h1>
        <p>
          This is a placeholder for the blog post content. Replace this with your dynamic data.
        </p>
      </section>
    );
  }
  