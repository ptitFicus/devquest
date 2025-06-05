package fr.maif.devquest.hero_management.hero_manamgement.model;

import java.util.Set;

public record SuccesQuete(String name, Set<String> morts, long gain) implements ResultatQuete {}
