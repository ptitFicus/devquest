package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.model.Groupe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {
    @GetMapping
    public Collection<Groupe> getGroupes() {
        return Collections.emptyList();
    }

    @PostMapping
    public ResponseEntity<Object> createGroupe(@RequestBody Groupe newGroupe) {
        System.out.println(newGroupe.name());
        return ResponseEntity.ok("");
    }

}
