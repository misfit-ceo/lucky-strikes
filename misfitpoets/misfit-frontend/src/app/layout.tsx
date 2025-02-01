// layout.tsx
// Location: misfitpoets/misfitpoets-frontend/src/app/layout.tsx
import '../styles/globals.css';
import MainNavBar from '../components/MainNavBar';
import Footer from '../components/Footer';

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <head>
        <title>MisfitPoets</title>
      </head>
      <body>
        <MainNavBar />
        <main>{children}</main>
        <Footer />
      </body>
    </html>
  );
}