/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "#121212",
        panel: "#1F1F1F",
        textPrimary: "#F5F5F5",
        gold: "#DAA520",
        goldHighlight: "#FFD700"
      },
    },
  },
  plugins: [],
};
