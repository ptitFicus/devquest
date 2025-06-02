package fr.maif.devquest.hero_management.hero_manamgement.datastore;

import fr.maif.devquest.hero_management.hero_manamgement.model.Groupe;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GroupeDatastore {
    public Optional<Groupe> groupe = Optional.empty();

    public void saveGroupe(Groupe groupe) {
        this.groupe = Optional.ofNullable(groupe);
    }

    public void reset() {
        this.groupe = Optional.empty();
    }
}
