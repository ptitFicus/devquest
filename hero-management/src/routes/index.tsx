import { createFileRoute, Link } from "@tanstack/react-router";
import "../App.css";

export const Route = createFileRoute("/")({
  component: App,
});

function App() {
  return (
    <div>
      Welcome to hero management
      <Link to="/new-team">Create new team</Link>
    </div>
  );
}
