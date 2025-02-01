// MainNavBar.tsx
// Location: misfitpoets/misfitpoets-frontend/src/components/MainNavBar.tsx
import Link from 'next/link';

export default function MainNavBar() {
  return (
    <nav className="bg-blue-600 text-white p-4 flex justify-between">
      <div className="font-bold text-xl">
        <Link href="/">MisfitPoets</Link>
      </div>
      <ul className="flex space-x-6">
        <li><Link href="/dashboard">Dashboard</Link></li>
        <li><Link href="/features">Features</Link></li>
        <li><Link href="/solutions">Solutions</Link></li>
        <li><Link href="/resources">Resources</Link></li>
        <li><Link href="/pricing">Pricing</Link></li>
        <li><Link href="/account">Account</Link></li>
        <li><Link href="/admin">Admin</Link></li>
        <li><Link href="/blog">Blog</Link></li>
        <li><Link href="/affiliates">Affiliates</Link></li>
      </ul>
    </nav>
  );
}
