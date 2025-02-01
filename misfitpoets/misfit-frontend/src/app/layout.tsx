import './globals.css';
import MainNavBar from '../components/MainNavBar';
import Footer from '../components/Footer';
import Head from 'next/head';

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <Head>
        <title>MisfitPoets</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
      </Head>
      <body>
        <MainNavBar />
        <main>{children}</main>
        <Footer />
      </body>
    </html>
  );
}
