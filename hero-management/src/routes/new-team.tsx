import { TeamEditor } from "@/components/TeamEditor";
import { loadAvailableMembers } from "@/queries";
import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/new-team")({
  component: RouteComponent,
  loader: () => loadAvailableMembers(),
});

function RouteComponent() {
  const availableMembers = Route.useLoaderData();
  return <TeamEditor availableMembers={availableMembers} />;
}
