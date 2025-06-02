package fr.maif.devquest.hero_management.hero_manamgement.model;

import java.util.Set;

public sealed interface ResultatQuete {
    Set<String> morts();
    String name();
    record SuccesQuete(String name, Set<String> morts, long gain) implements ResultatQuete {}
    record EchecQuete(String name, Set<String> morts) implements ResultatQuete {}
}


