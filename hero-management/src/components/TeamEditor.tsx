import { useState } from "react";
import { MOCK_MEMBERS } from "./MemberList";
import { TeamMember } from "./TeamMember";

export function TeamEditor() {
  const [name, setName] = useState("");
  const [members, setMembers] = useState<TeamMember[]>([]);

  return (
    <div>
      <h1>New team creation</h1>
      <label>
        Team name
        <input type="text" />
      </label>
      <h2>Team members</h2>
      {members.length === 0
        ? "No members"
        : members.map((member) => {
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
