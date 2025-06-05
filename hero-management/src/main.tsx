import { StrictMode, useEffect, useState } from "react";
import ReactDOM from "react-dom/client";
import { RouterProvider, createRouter } from "@tanstack/react-router";

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
  const [name, setName] = useState("");
  const [score, setScore] = useState(0);
  useEffect(() => {
    fetchMoney().then(({ money, name }) => {
      setMoney(money);
      setName(name);
      setScore(score);
    });
  }, []);
  return (
    <MoneyContext.Provider
      value={{
        score,
        money,
        refreshMoney: () => {
          fetchMoney().then(({ money, name, score }) => {
            setMoney(money);
            setName(name);
            setScore(score);
          });
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
            backgroundColor: "var(--sable)",
            zIndex: 100,
          }}
        >
          <h1>Hero manager</h1>
          <div
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "flex-end",
              justifyContent: "center",
            }}
          >
            <div style={{ fontWeight: "bold", fontSize: "1.2rem" }}>
              <span data-testid="username">{name}</span> -{" "}
              <span data-testid="money">{money}</span> 💰 -{" "}
              <span data-testid="score">{score} ⚔️</span>
            </div>
            <button
              className="devquest-btn-secondary"
              onClick={() => {
                fetch("/api/_reset", { method: "DELETE" }).then(() => {
                  location.replace("/landing-page");
                });
              }}
            >
              Abandonner
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
