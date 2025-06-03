import type { TeamMember } from "./components/TeamMember";

export interface Team {
  heros: TeamMember[];
}

export interface Quest {
  nom: string;
  difficulte: string;
}

export interface QuestResult {
  name: string;
  gain?: number;
  morts: string[];
}
