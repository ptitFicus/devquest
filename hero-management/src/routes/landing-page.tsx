import { createFileRoute, useNavigate } from "@tanstack/react-router";
import background from "../assets/landing.png";

export const Route = createFileRoute("/landing-page")({
  component: RouteComponent,
});

function RouteComponent() {
  const navigate = useNavigate({ from: "/landing-page" });
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
        <h1>Bienvenue aventurier !</h1>
        <form
          onSubmit={(e) => {
            e.preventDefault();
            const name = (e.target as any).name.value;
            const seed = (e.target as any).seed.value;
            console.log("seed");
            fetch(`/api/game`, {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify({
                name,
                seed: seed ? Number(seed) : null,
              }),
            }).then(() => {
              navigate({ to: "/" });
            });
          }}
          style={{ display: "flex", flexDirection: "column" }}
        >
          <label>
            Choisissez un nom
            <br />
            <input type="text" name="name" />
          </label>
          <label>
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
  );
}
