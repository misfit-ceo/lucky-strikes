// page.tsx
// Location: misfitpoets/misfitpoets-frontend/src/app/pricing/page.tsx
export default function PricingPage() {
    return (
      <div className="p-8">
        <h2 className="text-3xl font-bold">Pricing Plans</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
          {/* Starter Plan */}
          <div className="border p-4">
            <h3 className="font-bold">Starter (Free)</h3>
            <ul className="mt-2">
              <li>Basic Manuscript Editor</li>
              <li>Simple Formatting</li>
              <li>Community Access</li>
            </ul>
            <button className="mt-4 bg-blue-600 text-white py-2 px-4 rounded">Get Started</button>
          </div>
          {/* Pro Plan */}
          <div className="border p-4">
            <h3 className="font-bold">Pro ($49/month)</h3>
            <ul className="mt-2">
              <li>All Starter features</li>
              <li>Agent Match & Query Letter</li>
              <li>Advanced AI Cover Design</li>
              <li>Press Kit Builder</li>
            </ul>
            <button className="mt-4 bg-blue-600 text-white py-2 px-4 rounded">Upgrade</button>
          </div>
          {/* Premium Plan */}
          <div className="border p-4">
            <h3 className="font-bold">Premium ($99/month)</h3>
            <ul className="mt-2">
              <li>All Pro features</li>
              <li>Dynamic AI Pricing</li>
              <li>Beta Reader Distribution</li>
              <li>AI Audiobook Generation</li>
            </ul>
            <button className="mt-4 bg-blue-600 text-white py-2 px-4 rounded">Upgrade</button>
          </div>
          {/* Ultimate Plan */}
          <div className="border p-4">
            <h3 className="font-bold">Ultimate ($199/month)</h3>
            <ul className="mt-2">
              <li>All Premium features</li>
              <li>Worldwide Distribution</li>
              <li>Bestseller Tracking</li>
              <li>Full Sales Dashboard</li>
            </ul>
            <button className="mt-4 bg-blue-600 text-white py-2 px-4 rounded">Upgrade</button>
          </div>
        </div>
      </div>
    );
  }
  