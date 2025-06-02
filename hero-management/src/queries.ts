import type { TeamMember } from "./components/TeamMember";
import type { Quest, Team } from "./types";

export function loadAvailableMembers(): Promise<TeamMember[]> {
  return fetch("/api/heros").then((resp) => resp.json());
}

export function fetchTeam(): Promise<Team> {
  return fetch("/api/groupe").then((resp) => resp.json());
}

export function fetchQuests(): Promise<Quest[]> {
  return fetch("/api/quetes").then((resp) => resp.json());
}
