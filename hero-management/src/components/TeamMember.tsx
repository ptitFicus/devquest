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
  actions: { name?: string; callback?: () => any; disabled?: boolean }[];
  achievements: boolean;
}) {
  const { role, name, achievements } = props.details;
  return (
    <div
      style={{
        padding: "0.5rem 1rem",
        border: "1px solid var(--tertiary-color)",
        backgroundColor: "var(--vert)",
        color: "white",
        borderRadius: "0.5rem",
        display: "flex",
        flexDirection: "column",
        position: "relative",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <h3 style={{ display: "flex", flexDirection: "row", margin: "0" }}>
        {name}&nbsp;
      </h3>
      <img
        src={classLogo(role)}
        style={{ width: "1.5rem", height: "1.5rem" }}
      />
      {props?.achievements && (
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <ul style={{ listStyleType: "none", padding: "0" }}>
            {achievements.map((achievement) => {
              return <li>{achievement}</li>;
            })}
          </ul>
        </div>
      )}
      {props?.actions
        ?.filter((a) => a.name && a.callback)
        ?.map(({ name, callback, disabled }) => {
          return (
            <button
              className="devquest-btn-secondary"
              disabled={disabled}
              onClick={callback}
            >
              {name}
            </button>
          );
        })}
    </div>
  );
}

export function classLogo(className: string) {
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
