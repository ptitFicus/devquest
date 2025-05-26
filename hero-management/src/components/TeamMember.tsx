import archer from "../assets/archer.png";
import dwarf from "../assets/dwarf.png";
import elf from "../assets/elf.png";
import group from "../assets/group.png";
import king from "../assets/king.png";
import knight from "../assets/knight.png";
import necromancer from "../assets/necromancer.png";
import shaman from "../assets/shaman.png";
import wizard from "../assets/wizard.png";

export const HERO_CLASSES = [
  "archer",
  "dwarf",
  "elf",
  "group",
  "king",
  "knight",
  "necromancer",
  "shaman",
  "wizard",
] as const;

export type heroClassType = (typeof HERO_CLASSES)[number];

export interface TeamMember {
  name: string;
  achievements: string[];
  role: heroClassType;
}

export function TeamMember(props: {
  details: TeamMember;
  light: boolean;
  actionText: string;
  onAction: () => any;
}) {
  const { role, name, achievements } = props.details;
  return (
    <div
      style={{
        border: "1px solid blue",
        display: "flex",
        flexDirection: "column",
        position: "relative",
      }}
    >
      <h3 style={{ display: "flex", flexDirection: "row" }}>
        {name}&nbsp;
        <img
          src={classLogo(role)}
          style={{ width: "1.5rem", height: "1.5rem" }}
        />
      </h3>
      <div style={{ display: "flex", justifyContent: "space-between" }}>
        {!props?.light && (
          <ul style={{ listStyleType: "none", padding: "0" }}>
            {achievements.map((achievement) => {
              return <li>{achievement}</li>;
            })}
          </ul>
        )}
        <button style={{ margin: "2rem" }} onClick={props.onAction}>
          {props.actionText}
        </button>
      </div>
    </div>
  );
}

function classLogo(className: string) {
  switch (className) {
    case "archer":
      return archer;
    case "dwarf":
      return dwarf;
    case "elf":
      return elf;
    case "group":
      return group;
    case "king":
      return king;
    case "knight":
      return knight;
    case "necromancer":
      return necromancer;
    case "shaman":
      return shaman;
    case "wizard":
      return wizard;
    default:
      return "";
  }
}
