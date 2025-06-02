import { useState } from "react";
import { TeamMember } from "./TeamMember";
import { TeamDetails } from "./TeamDetails";

export function TeamEditor({
  availableMembers,
}: {
  availableMembers: TeamMember[];
}) {
  const [name, setName] = useState("");
  const [members, setMembers] = useState<TeamMember[]>([]);

  return (
    <div>
      <h1>Création d'un nouveau groupe</h1>
      <h2>Membres du groupe</h2>
      <TeamDetails
        actions={[]}
        team={{ name, heros: members }}
        memberActions={[
          (member) => {
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
          value={name}
          onChange={(e) => setName(e?.target?.value)}
        />
      </label>
      <button
        onClick={() => {
          fetch("/api/groupe", {
            method: "POST",
            body: JSON.stringify({
              name: name,
              heros: members,
            }),
            headers: {
              "Content-Type": "application/json",
            },
          });
        }}
      >
        Créer le groupe
      </button>
      <h2>Available members</h2>
      {availableMembers
        .filter((member) => !members.find((m) => m.name === member.name))
        .map((member) => {
          return (
            <div style={{ margin: "4px" }}>
              <TeamMember
                details={member}
                light={false}
                actions={[
                  {
                    name: `Recruter ${member.name}`,
                    callback: () =>
                      setMembers((members) => [...members, member]),
                  },
                ]}
                achievements={true}
              />
            </div>
          );
        })}
    </div>
  );
}
