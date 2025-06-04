import { StrictMode, useEffect, useState } from "react";
import ReactDOM from "react-dom/client";
import {
  RouterProvider,
  createRouter,
  useMatchRoute,
} from "@tanstack/react-router";

// Import the generated route tree
import { routeTree } from "./routeTree.gen";

import "./styles.css";
import reportWebVitals from "./reportWebVitals.ts";
import { MoneyContext } from "./moneyContext.ts";

// Create a new router instance
const router = createRouter({
  routeTree,
  context: {},
  defaultPreload: "intent",
  scrollRestoration: true,
  defaultStructuralSharing: true,
  defaultPreloadStaleTime: 0,
});

// Register the router instance for type safety
declare module "@tanstack/react-router" {
  interface Register {
    router: typeof router;
  }
}

// Render the app
const rootElement = document.getElementById("app");
if (rootElement && !rootElement.innerHTML) {
  const root = ReactDOM.createRoot(rootElement);
  root.render(
    <StrictMode>
      <Layout />
    </StrictMode>
  );
}

function fetchMoney() {
  return fetch("/api/game").then((resp) => resp.json());
}

function Layout() {
  const [money, setMoney] = useState(0);
  useEffect(() => {
    fetchMoney().then(({ money }) => setMoney(money));
  }, []);
  return (
    <MoneyContext.Provider
      value={{
        money,
        refreshMoney: () => {
          fetchMoney().then(({ money }) => setMoney(money));
        },
      }}
    >
      <div
        style={{ height: "100vh", display: "flex", flexDirection: "column" }}
      >
        <header
          style={{
            display: "flex",
            flexDirection: "row",
            flexGrow: 0,
            justifyContent: "space-between",
            alignItems: "center",
            padding: "0 2rem",
            backgroundColor: "rgba(255,255,255,0.5)",
            zIndex: 100,
          }}
        >
          <h1>Hero management</h1>
          <div>
            <div
              data-testid="money"
              style={{ fontWeight: "bold", fontSize: "1.2rem" }}
            >
              {money} 💰
            </div>
            <button
              onClick={() => {
                fetch("/api/_reset", { method: "DELETE" }).then(() => {
                  location.reload();
                });
              }}
            >
              Restart game
            </button>
          </div>
        </header>

        <div style={{ flexGrow: "1" }}>
          <RouterProvider router={router} />
        </div>
      </div>
    </MoneyContext.Provider>
  );
}

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
