import type { Team } from "@/types";
import { TeamMember } from "./TeamMember";

export function TeamDetails({
  team,
  memberActions,
  actions,
}: {
  team: Team;
  memberActions: ((member: TeamMember) => {
    name?: string;
    callback?: () => any;
  })[];
  actions: {
    name?: string;
    callback?: () => any;
  }[];
}) {
  return (
    <>
      <ul
        style={{
          listStyleType: "none",
          padding: "0px",
          display: "flex",
          flexWrap: "wrap",
          flexDirection: "row",
          justifyContent: "center",
        }}
      >
        {team.heros.map((member) => {
          return (
            <li style={{ margin: "0.5rem" }}>
              <TeamMember
                details={member}
                light={true}
                actions={memberActions?.map((actionCreator) => {
                  return actionCreator(member);
                })}
                achievements={false}
              />
            </li>
          );
        })}
      </ul>
      {actions?.map(({ name, callback }) => {
        return (
          <button type="button" onClick={() => callback?.()}>
            {name}
          </button>
        );
      })}
    </>
  );
}
