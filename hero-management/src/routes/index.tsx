import {
  createFileRoute,
  Link,
  redirect,
  useRouter,
} from "@tanstack/react-router";
import "../App.css";
import { fetchQuests, fetchTeam } from "@/queries";
import type { Quest, QuestResult, Team } from "@/types";
import { TeamDetails } from "@/components/TeamDetails";
import { useContext, useRef, useState } from "react";
import { MoneyContext } from "@/moneyContext";
import index from "../assets/index.png";

export const Route = createFileRoute("/")({
  component: App,
  loader: () => {
    return Promise.all([fetchTeam(), fetchQuests()]).then(([team, quests]) => {
      return { team, quests };
    });
  },
  beforeLoad: async () => {
    const gameInfo = await fetch("/api/game").then((r) => r.json());
    if (gameInfo.name === null) {
      throw redirect({
        to: "/landing-page",
        search: {
          redirect: location.href,
        },
      });
    }
  },
});

function App() {
  const { team, quests } = Route.useLoaderData();
  const { money } = useContext(MoneyContext);

  if ((!team || team?.heros?.length === 0) && money < 1000) {
    return (
      <div
        style={{
          position: "absolute",
          top: "0",
          bottom: "0",
          right: "0",
          left: "0",
          backgroundImage: `url(${index})`,
          backgroundColor: "rgba(255,255,255,0.5)",
        }}
      >
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
    <div
      style={{
        backgroundImage: `url(${index})`,
        height: "100%",
      }}
    >
      <div
        style={{
          padding: "0 2.5rem",
          display: "flex",
          flexDirection: "row",
          backgroundColor: "rgba(255,255,255,0.5)",
          height: "100%",
        }}
      >
        <div
          style={{
            width: "50%",
            height: "33%",
            flexGrow: 1,
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center",
            backgroundImage: "",
          }}
        >
          {team ? (
            <>
              <TeamDisplay team={team} />
              {team.heros.length < 4 && (
                <Link className="devquest-btn" to="/new-team" search={team}>
                  Compléter l'équipe
                </Link>
              )}
            </>
          ) : (
            <div
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                alignItems: "center",
                height: "100%",
              }}
            >
              <Link to="/new-team" className="devquest-btn">
                Créé ton équipe !
              </Link>
            </div>
          )}
        </div>
        {team && (
          <div style={{ width: "45%" }}>
            <QuestList quests={quests} canStart={team?.heros?.length > 0} />
          </div>
        )}
      </div>
    </div>
  );
}

export function TeamDisplay({ team }: { team: Team }) {
  return (
    <div>
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
      <h3>Quêtes</h3>
      <ul>
        {quests.map((quest) => {
          return (
            <li>
              {quest.nom}({quest.difficulte})
              <button
                className="devquest-btn-secondary"
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
        style={{ marginLeft: "10rem" }}
        className="devquest-btn-secondary"
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
