import { createFileRoute, Link, useRouter } from "@tanstack/react-router";
import "../App.css";
import { fetchQuests, fetchTeam } from "@/queries";
import type { Quest, QuestResult, Team } from "@/types";
import { TeamDetails } from "@/components/TeamDetails";
import { useContext, useRef, useState } from "react";
import { MoneyContext } from "@/moneyContext";

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
  const { money } = useContext(MoneyContext);

  if ((!team || team?.heros?.length === 0) && money < 1000) {
    return (
      <div>
        <div>Partie terminée</div>
        <button
          onClick={() => {
            fetch("/api/_reset", { method: "DELETE" }).then(() => {
              location.reload();
            });
          }}
        >
          Rejouer
        </button>
      </div>
    );
  }

  return (
    <div style={{ padding: "0 2.5rem" }}>
      <div style={{ display: "flex", flexDirection: "row" }}>
        <div style={{ width: "50%" }}>
          <div>
            {team ? (
              <>
                <TeamDisplay team={team} />
                <Link to="/new-team" search={team}>
                  Edit team
                </Link>
              </>
            ) : (
              <Link to="/new-team">Create your team</Link>
            )}
          </div>
        </div>
        <div style={{ width: "45%" }}>
          <QuestList quests={quests} canStart={team?.heros?.length > 0} />
        </div>
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
  );
}

export function TeamDisplay({ team }: { team: Team }) {
  return (
    <div>
      <h2>{team.name}</h2>
      {team.heros.length === 0 ? (
        "Aucun membre dans votre groupe"
      ) : (
        <TeamDetails team={team} memberActions={[]} actions={[]} />
      )}
    </div>
  );
}

function QuestList({
  quests,
  canStart,
}: {
  quests: Quest[];
  canStart: boolean;
}) {
  const route = useRouter();
  const dialogRef = useRef<HTMLDialogElement>(null);
  const [questResult, setQuestResult] = useState<QuestResult | null>(null);
  const { refreshMoney, money } = useContext(MoneyContext);
  return (
    <>
      <ul>
        {quests.map((quest) => {
          return (
            <li>
              {quest.nom}({quest.difficulte})
              <button
                disabled={!canStart}
                type="button"
                onClick={() => {
                  fetch(`/api/quetes/${quest.nom}/_commencer`, {
                    method: "POST",
                  })
                    .then((res) => res.json())
                    .then((questResult) => {
                      setQuestResult(questResult);
                      route.invalidate();
                      refreshMoney();
                    })
                    .then(() => {});
                }}
              >
                commencer
              </button>
            </li>
          );
        })}
      </ul>
      <button
        onClick={() =>
          fetch(`/api/quetes/_reroll`, { method: "POST" }).then(() => {
            route.invalidate();
            refreshMoney();
          })
        }
        disabled={money < 1000}
      >
        Reroll (1000💰)
      </button>
      {questResult && (
        <dialog open ref={dialogRef}>
          <QuestResultDetails result={questResult} />
          <button onClick={() => setQuestResult(null)}>OK</button>
        </dialog>
      )}
    </>
  );
}

function QuestResultDetails({ result }: { result: QuestResult }) {
  const success = Boolean(result.gain);
  return (
    <div>
      <h4>
        La quête {result.name}
        {success ? " est un succès" : " a échoué"}
      </h4>
      {success && `Vous avez gagné ${result.gain}💰`}
      <br />
      {result.morts?.length > 0 ? (
        <>
          <h5>Les héros suivants sont tombés au combat</h5>
          <ul>
            {result.morts.map((name) => (
              <li>{name}</li>
            ))}
          </ul>
        </>
      ) : (
        "Aucun mort à déplorer !"
      )}
    </div>
  );
}
