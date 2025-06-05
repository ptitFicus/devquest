import { TeamDetails } from "@/components/TeamDetails";
import { TeamMember } from "@/components/TeamMember";
import { MoneyContext } from "@/moneyContext";
import { loadAvailableMembers } from "@/queries";
import type { Team } from "@/types";
import {
  createFileRoute,
  useNavigate,
  useRouter,
} from "@tanstack/react-router";
import { useContext, useState } from "react";
import groupe from "../assets/groupe.png";

export const Route = createFileRoute("/new-team")({
  component: RouteComponent,
  loader: () => loadAvailableMembers(),
});

function RouteComponent() {
  const availableMembers = Route.useLoaderData();
  return <TeamEditor availableMembers={availableMembers} />;
}

export function TeamEditor({
  availableMembers,
}: {
  availableMembers: TeamMember[];
}) {
  const [members, setMembers] = useState<TeamMember[]>([]);
  const navigation = useNavigate({ from: "/new-team" });
  const currentTeam: Team = Route.useSearch();
  const { refreshMoney, money } = useContext(MoneyContext);
  const [creating, setCreating] = useState(false);
  const route = useRouter();

  return (
    <div
      style={{
        backgroundImage: `url(${groupe})`,
      }}
    >
      <div
        style={{
          backgroundColor: "rgba(255,255,255,0.8)",
          padding: "0.5rem 2rem",
        }}
      >
        <h1>
          {currentTeam?.heros
            ? `Édition du groupe`
            : "Création d'un nouveau groupe"}
        </h1>
        <h2>Membres du groupe</h2>
        <TeamDetails
          actions={[]}
          team={{ heros: (currentTeam?.heros ?? []).concat(members) }}
          memberActions={[
            (member) => {
              if (currentTeam?.heros?.find((m) => m.name === member.name)) {
                return {};
              } else
                return {
                  name: `Renvoyer ${member.name}`,
                  callback: () => {
                    setMembers((members) =>
                      members.filter((m) => m.name !== member.name)
                    );
                  },
                };
            },
          ]}
        />
        <div
          style={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <button
            className="devquest-btn"
            onClick={() => {
              fetch("/api/groupe", {
                method: "POST",
                body: JSON.stringify({
                  heros: (currentTeam?.heros ?? []).concat(members),
                }),
                headers: {
                  "Content-Type": "application/json",
                },
              })
                .then(() => refreshMoney())
                .then(() => navigation({ to: "/" }));
            }}
          >
            {currentTeam?.heros ? "Mettre à jour le groupe" : "Créer le groupe"}
          </button>
        </div>
        <h2>Héros disponibles</h2>
        {!creating && (
          <button
            className="devquest-btn-secondary"
            onClick={() => setCreating(true)}
          >
            Invoquer un nouveau héro
          </button>
        )}
        {creating && (
          <HeroForm
            onSubmit={(h) => {
              fetch("/api/heros", {
                method: "POST",
                body: JSON.stringify(h),
                headers: {
                  "Content-Type": "application/json",
                },
              })
                .then(() => route.invalidate())
                .then(() => setCreating(false));
            }}
          />
        )}
        <div
          style={{
            display: "flex",
            flexDirection: "row",
            flexWrap: "wrap",
            justifyContent: "space-around",
          }}
        >
          {availableMembers
            .filter((member) => {
              return (
                !members.find((m) => m.name === member.name) &&
                !(currentTeam?.heros ?? []).find((m) => m.name === member.name)
              );
            })
            .map((member) => {
              return (
                <div style={{ margin: "1rem 0.5rem", width: "30vw" }}>
                  <TeamMember
                    details={member}
                    light={false}
                    actions={
                      (currentTeam?.heros ?? []).concat(members).length < 4
                        ? [
                            {
                              name: `Recruter ${member.name} (1000💰)`,
                              callback: () =>
                                setMembers((members) => [...members, member]),
                              disabled: money - members.length * 1000 < 1000,
                            },
                          ]
                        : []
                    }
                    achievements={true}
                  />
                </div>
              );
            })}
        </div>
      </div>
    </div>
  );
}

function HeroForm(props: { onSubmit: (member: TeamMember) => any }) {
  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        const target = event.target as any;
        const name = target.name.value;
        const classe = target.classe.value;
        const exploits = target.exploits.value.split("\n");

        props?.onSubmit({
          name,
          role: classe,
          achievements: exploits,
        });
      }}
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
      <h3>Invocation d'un héro</h3>
      <label style={{ padding: "0.5rem 0" }}>
        Nom&nbsp;<input name="name" type="text"></input>
      </label>
      <label style={{ padding: "0.5rem 0" }}>
        Classe&nbsp;
        <div className="select">
          <select name="classe">
            {[
              "archer",
              "dwarf",
              "elf",
              "king",
              "knight",
              "necromancer",
              "shaman",
              "wizard",
            ].map((cl) => {
              return <option>{cl}</option>;
            })}
          </select>
          <span className="focus"></span>
        </div>
      </label>
      <label style={{ padding: "0.5rem 0" }}>
        Exploits (1 exploit / ligne)
        <br />
        <textarea name="exploits" style={{ width: 500, height: 80 }}></textarea>
      </label>
      <button type="submit" className="devquest-btn-secondary">
        Invoquer le héro (1000 💰)
      </button>
    </form>
  );
}
