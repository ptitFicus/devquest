package fr.maif.devquest.hero_management.hero_manamgement.datastore;

import fr.maif.devquest.hero_management.hero_manamgement.model.Difficulte;
import fr.maif.devquest.hero_management.hero_manamgement.model.Quete;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class QueteRepository {
    private Map<String, Difficulte> quetes = new HashMap<>();

    public void createQuete(Quete quete) {
        this.quetes.put(quete.nom(), quete.difficulte());
    }

    public void deleteQuete(String name) {
        this.quetes.remove(name);
    }

    public Optional<Quete> readQuete(String name) {
        return Optional.ofNullable(quetes.get(name)).map(diff->
            new Quete(name, diff)
        );
    }

    public List<Quete> readQuetes() {
        return quetes.entrySet().stream().map(entry -> new Quete(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

    public void reset() {
        this.quetes.clear();
    }
}
