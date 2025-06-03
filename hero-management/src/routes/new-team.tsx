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
  const [name, setName] = useState("");
  const [members, setMembers] = useState<TeamMember[]>([]);
  const navigation = useNavigate({ from: "/new-team" });
  const currentTeam: Team = Route.useSearch();
  console.log("currentTeam", currentTeam);
  const { refreshMoney, money } = useContext(MoneyContext);
  const [creating, setCreating] = useState(false);
  const route = useRouter();

  return (
    <div>
      <h1>
        {currentTeam?.name
          ? `Édition du groupe ${currentTeam?.name}`
          : "Création d'un nouveau groupe"}
      </h1>
      <h2>Membres du groupe</h2>
      <TeamDetails
        actions={[]}
        team={{ name, heros: (currentTeam?.heros ?? []).concat(members) }}
        memberActions={[
          (member) => {
            console.log("currentTeam", currentTeam);
            console.log("member", member);
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
      <label style={{ display: "block" }}>
        Nom du groupe
        <input
          type="text"
          disabled={Boolean(currentTeam?.name)}
          value={currentTeam ? currentTeam.name : name}
          onChange={(e) => setName(e?.target?.value)}
        />
      </label>
      <button
        onClick={() => {
          fetch("/api/groupe", {
            method: "POST",
            body: JSON.stringify({
              name: currentTeam?.name ?? name,
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
        {currentTeam?.name ? "Mettre à jour le groupe" : "Créer le groupe"}
      </button>
      <h2>Available members</h2>
      {!creating && (
        <button onClick={() => setCreating(true)}>
          Invoquer un nouveau héro
        </button>
      )}
      {creating && (
        <HeroForm
          onSubmit={(h) => {
            console.log("coucou", h);
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
      {availableMembers
        .filter((member) => {
          return (
            !members.find((m) => m.name === member.name) &&
            !(currentTeam?.heros ?? []).find((m) => m.name === member.name)
          );
        })
        .map((member) => {
          return (
            <div style={{ margin: "4px" }}>
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
  );
}

function HeroForm(props: { onSubmit: (member: TeamMember) => any }) {
  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        const name = event.target.name.value;
        const classe = event.target.classe.value;
        const exploits = event.target.exploits.value.split("\n");

        props?.onSubmit({
          name,
          role: classe,
          achievements: exploits,
        });
      }}
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "flex-start",
      }}
    >
      <label>
        Name&nbsp;<input name="name" type="text"></input>
      </label>
      <label>
        Classe&nbsp;
        <select name="classe">
          {[
            "archer",
            "dwarf",
            "elf",
            "group",
            "king",
            "knight",
            "necromancer",
            "shaman",
            "wizard",
          ].map((cl) => {
            return <option>{cl}</option>;
          })}
        </select>
      </label>
      <label>
        Exploits (1 exploit / ligne)
        <br />
        <textarea name="exploits" style={{ width: 500, height: 80 }}></textarea>
      </label>
      <button type="submit">Créer le héro</button>
    </form>
  );
}
