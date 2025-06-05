import { createFileRoute, useNavigate } from "@tanstack/react-router";
import background from "../assets/landing.png";
import { useContext } from "react";
import { MoneyContext } from "@/moneyContext";

export const Route = createFileRoute("/landing-page")({
  component: RouteComponent,
});

function RouteComponent() {
  const navigate = useNavigate({ from: "/landing-page" });
  const { refreshMoney } = useContext(MoneyContext);
  return (
    <div
      style={{
        position: "absolute",
        top: "0",
        bottom: "0",
        right: "0",
        left: "0",
        backgroundImage: `url(${background})`,
        zIndex: 1001,
      }}
    >
      <div
        style={{
          backgroundColor: "rgba(255, 255, 255, 0.5)",
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          alignItems: "center",
          height: "100vh",
        }}
      >
        <div
          style={{
            backgroundColor: "var(--vert)",
            border: "1px solid var(--tertiary-color)",
            padding: "0.5rem 1rem",
            display: "inline-flex",
            color: "white",
            flexDirection: "column",
            alignItems: "stretch",
            borderRadius: "0.5rem",
            justifyContent: "stretch",
          }}
        >
          <h1 color="white">Bienvenue aventurier !</h1>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              const name = (e.target as any).name.value;
              const seed = (e.target as any).seed.value;
              fetch(`/api/game`, {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
                body: JSON.stringify({
                  name,
                  seed: seed ? Number(seed) : null,
                }),
              })
                .then(() => {
                  refreshMoney();
                })
                .then(() => {
                  navigate({ to: "/" });
                });
            }}
            style={{ display: "flex", flexDirection: "column" }}
          >
            <label style={{ padding: "0.5rem 0" }}>
              Choisissez un nom
              <br />
              <input type="text" name="name" />
            </label>
            <label style={{ padding: "0.5rem 0" }}>
              Seed
              <br />
              <input type="number" name="seed" />
            </label>
            <button className="devquest-btn" type="submit">
              Commencer l'aventure !
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
