import { createFileRoute, Link, useRouter } from "@tanstack/react-router";
import "../App.css";
import { fetchQuests, fetchTeam } from "@/queries";
import type { Quest, Team } from "@/types";
import { TeamDetails } from "@/components/TeamDetails";

export const Route = createFileRoute("/")({
  component: App,
  loader: () => {
    return Promise.all([fetchTeam(), fetchQuests()]).then(([team, quests]) => {
      return { team, quests };
    });
  },
});

function App() {
  const { team, quests } = Route.useLoaderData();
  return (
    <div>
      <h1>Hero management</h1>
      <div style={{ display: "flex", flexDirection: "row" }}>
        <div style={{ width: "50%" }}>
          <div>{team ? <TeamDisplay team={team} /> : <>No team yet</>}</div>
          <Link to="/new-team">Create new team</Link>
        </div>
        <div style={{ width: "45%" }}>
          <QuestList quests={quests} />
        </div>
      </div>
    </div>
  );
}

export function TeamDisplay({ team }: { team: Team }) {
  return (
    <div>
      <h2>{team.name}</h2>
      <TeamDetails team={team} memberActions={[]} actions={[]} />
    </div>
  );
}

function QuestList({ quests }: { quests: Quest[] }) {
  const route = useRouter();

  return (
    <ul>
      {quests.map((quest) => {
        return (
          <li>
            {quest.nom}({quest.difficulte})
            <button
              type="button"
              onClick={() => {
                fetch(`/api/quetes/${quest.nom}/_commencer`, {
                  method: "POST",
                }).then(() => {
                  route.invalidate();
                });
              }}
            >
              commencer
            </button>
          </li>
        );
      })}
    </ul>
  );
}
