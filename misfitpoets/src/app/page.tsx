// src/app/page.tsx (Homepage)

export default function Home() {
  return (
    <section className="text-center">
      <h1 className="text-3xl font-bold mb-4">Welcome to Misfit Poets</h1>
      <p className="text-gray-700 mb-6">
       Unleash Your Writing Potential
      </p>

      <div className="flex justify-center space-x-4">
        <a href="/library" className="btn">
          Visit Library
        </a>
        <a href="/blog" className="btn">
          Read Blog
        </a>
      </div>
    </section>
  );
}
