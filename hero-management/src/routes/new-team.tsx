import { TeamEditor } from "@/components/TeamEditor";
import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/new-team")({
  component: RouteComponent,
});

function RouteComponent() {
  return <TeamEditor />;
}
