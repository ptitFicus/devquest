import { useState } from "react";
import { MOCK_MEMBERS } from "./MemberList";
import { TeamMember } from "./TeamMember";

export function TeamEditor() {
  const [name, setName] = useState("");
  const [members, setMembers] = useState<TeamMember[]>([]);

  return (
    <div>
      <h1>Création d'un nouveau groupe</h1>
      <h2>Membres du groupe</h2>
      {members.map((member) => {
        return (
          <TeamMember
            details={member}
            light={true}
            actionText="Renvoyer"
            onAction={() => {
              setMembers((members) =>
                members.filter((m) => m.name !== member.name)
              );
            }}
          />
        );
      })}
      <label style={{ display: "block" }}>
        Nom du groupe
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e?.target?.value)}
        />
      </label>
      <button
        onClick={(e) => {
          fetch("/api/groupes", {
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
      {MOCK_MEMBERS.filter(
        (member) => !members.find((m) => m.name === member.name)
      ).map((member) => {
        return (
          <div style={{ margin: "4px" }}>
            <TeamMember
              details={member}
              light={false}
              actionText="Recruter"
              onAction={() => setMembers((members) => [...members, member])}
            />
          </div>
        );
      })}
    </div>
  );
}
