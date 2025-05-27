package fr.maif.devquest.hero_management.hero_manamgement.model;

import java.util.Collection;

public record Groupe(String name, Collection<Hero> heros) {}
