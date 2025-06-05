package fr.maif.devquest.hero_management.hero_manamgement.model;

import java.util.Set;

public record EchecQuete(String name, Set<String> morts) implements ResultatQuete {}
