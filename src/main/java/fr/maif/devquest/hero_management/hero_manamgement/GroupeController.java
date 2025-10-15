package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Groupe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groupe")
public class GroupeController {
    private final GameDatastore gameDatastore;
    private GroupeDatastore groupeDatastore;
    private boolean isOff;

    public GroupeController(GroupeDatastore groupeDatastore, GameDatastore gameDatastore, @Value("${nobackend}") Boolean isOff) {
        this.groupeDatastore = groupeDatastore;
        this.gameDatastore = gameDatastore;
        this.isOff = isOff;
    }

    @GetMapping
    public Object getGroupes() {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        return groupeDatastore.groupe;
        /*if(groupeDatastore.groupe.isPresent()) {
            return groupeDatastore.groupe.get();
        } else {
            return new HashMap<>();
        }*/
    }

    @PostMapping
    public ResponseEntity<Object> createGroupe(@RequestBody Groupe newGroupe) {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        Collection<String> oldMembers = groupeDatastore.groupe.map(g -> g.heros().stream().map(h -> h.name()).collect(Collectors.toList())).orElseGet(Collections::emptyList);
        int diff = newGroupe.heros().size() - oldMembers.size();
        gameDatastore.withdraw(diff * 1_000L);
        groupeDatastore.saveGroupe(newGroupe);
        return ResponseEntity.ok("");
    }

}
