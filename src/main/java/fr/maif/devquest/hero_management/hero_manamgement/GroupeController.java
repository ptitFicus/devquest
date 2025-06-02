package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Groupe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupe")
public class GroupeController {
    private GroupeDatastore groupeDatastore;

    public GroupeController(GroupeDatastore groupeDatastore) {
        this.groupeDatastore = groupeDatastore;
    }

    @GetMapping
    public Object getGroupes() {
        return groupeDatastore.groupe;
        /*if(groupeDatastore.groupe.isPresent()) {
            return groupeDatastore.groupe.get();
        } else {
            return new HashMap<>();
        }*/
    }

    @PostMapping
    public ResponseEntity<Object> createGroupe(@RequestBody Groupe newGroupe) {
        groupeDatastore.saveGroupe(newGroupe);
        return ResponseEntity.ok("");
    }

}
