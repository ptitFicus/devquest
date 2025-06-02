import type { TeamMember } from "./components/TeamMember";

export interface Team {
  name: string;
  heros: TeamMember[];
}

export interface Quest {
  nom: string;
  difficulte: string;
}
