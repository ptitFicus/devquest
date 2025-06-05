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
import mission from "../assets/mission.png";

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
    return gameInfo;
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
          zIndex: "2000",
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "center",
        }}
      >
        <div
          style={{
            padding: "2rem",
            border: "3px solid var(--primary-color)",
            backgroundColor: "var(--sable)",
            color: "black",
            borderRadius: "0.5rem",
            display: "flex",
            flexDirection: "column",
            position: "relative",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <h1>Partie terminée !</h1>
          <button
            className="devquest-btn"
            onClick={() => {
              fetch("/api/_reset", { method: "DELETE" }).then(() => {
                location.reload();
              });
            }}
          >
            Rejouer
          </button>
        </div>
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
                Crée ton équipe !
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
      <div style={{ position: "relative", height: "100%" }}>
        <div id="parchment"></div>
        <div
          style={{
            width: "75%",
            position: "absolute",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            flexDirection: "column",
            padding: "1rem 4rem",
            fontFamily: "'Brush Script MT', cursive",
            fontSize: "1.5rem",
            margin: "2rem",
            top: "0",
            bottom: "0",
            overflowY: "scroll",
          }}
        >
          <h2
            style={{
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
              justifyContent: "center",
              fontSize: "3rem",
              margin: "0",
            }}
          >
            <img
              src={mission}
              style={{ width: "5rem", height: "5rem", marginBottom: "1rem" }}
              aria-hidden
            />
            <br />
            &nbsp;Quêtes
          </h2>
          <ul
            style={{
              padding: "0",
              margin: "0",
              flexGrow: "1",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              flexDirection: "column",
            }}
          >
            {quests.map((quest) => {
              return (
                <li
                  style={{
                    margin: "0",
                    listStyle: "none",
                    display: "flex",
                    flexDirection: "column",
                    justifyContent: "space-around",
                    alignItems: "center",
                    fontSize: "2rem",
                  }}
                >
                  {quest.nom}
                  <br />
                  {<QuestDifficulty difficulty={quest.difficulte} />}
                  <br />
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
          <div
            style={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <button
              style={{}}
              className="devquest-btn"
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
          </div>
        </div>
        <svg>
          <filter id="wavy2">
            <feTurbulence
              x="0"
              y="0"
              baseFrequency="0.02"
              numOctaves="5"
              seed="1"
            />
            <feDisplacementMap in="SourceGraphic" scale="20" />
          </filter>
        </svg>
      </div>
      {questResult && (
        <div
          style={{
            position: "absolute",
            top: "0",
            bottom: "0",
            right: "0",
            left: "0",
            backgroundColor: "rgba(0,0,0,0.5)",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <dialog
            open
            ref={dialogRef}
            style={{
              border: "5px solid var(--secondary-color)",
              backgroundColor: "var(--sable)",
              display: "flex",
              flexDirection: "column",
            }}
          >
            <QuestResultDetails result={questResult} />
            <button
              className="devquest-btn-secondary"
              onClick={() => setQuestResult(null)}
            >
              OK
            </button>
          </dialog>
        </div>
      )}
    </>
  );
}

function QuestResultDetails({ result }: { result: QuestResult }) {
  const success = Boolean(result.gain);
  return (
    <div>
      <h2>
        La quête "{result.name.toLowerCase()}"
        {success ? " est un succès" : " a échoué"}
      </h2>
      {success && `Vous avez gagné ${result.gain} 💰`}
      <br />
      {result.morts?.length > 0 ? (
        <>
          <h3>Les héros suivants sont tombés au combat</h3>
          <ul>
            {result.morts.map((name) => (
              <li
                style={{
                  listStyle: "none",
                  color: "var(--vert)",
                  fontWeight: "bold",
                }}
              >
                🪦&nbsp;{name}
              </li>
            ))}
          </ul>
        </>
      ) : (
        "Aucun mort à déplorer !"
      )}
    </div>
  );
}

function QuestDifficulty({ difficulty }: { difficulty: string }) {
  switch (difficulty) {
    case "FACILE":
      return (
        <span role="img" aria-label="facile">
          ⚔️
        </span>
      );
    case "MOYEN":
      return (
        <span role="img" aria-label="moyen">
          ⚔️⚔️
        </span>
      );
    case "DIFFICILE":
      return (
        <span role="img" aria-label="difficile">
          ⚔️⚔️⚔️
        </span>
      );
    case "EXTREME":
      return (
        <span role="img" aria-label="extreme">
          ⚔️⚔️⚔️⚔️
        </span>
      );
    case "IMPOSSIBLE":
      return (
        <span role="img" aria-label="impossible">
          ⚔️⚔️⚔️⚔️⚔️
        </span>
      );
    default:
      return "";
  }
}
