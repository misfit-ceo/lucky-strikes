// tailwind.config.js
module.exports = {
  content: [
    "./src/**/*.{js,ts,jsx,tsx}",
    "./src/app/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "#121212",    // near-black background
        panel: "#1F1F1F",        // slightly lighter for sections/panels
        textPrimary: "#F5F5F5",  // off-white for text
        gold: "#DAA520",         // main gold accent
        goldHighlight: "#FFD700" // brighter gold for hovers or special highlights
      },
    },
  },
  plugins: [],
};
