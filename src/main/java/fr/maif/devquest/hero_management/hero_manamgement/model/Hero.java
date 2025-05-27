package fr.maif.devquest.hero_management.hero_manamgement.model;

import java.util.Collection;

public record Hero(String name, Collection<String> achievements, Classe role) {}
