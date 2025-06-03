package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/_reset")
public class ResetController {
    private final GroupeDatastore groupeDatastore;
    private final QueteService queteService;
    private final GameDatastore gameDatastore;

    public ResetController(GroupeDatastore groupeDatastore, QueteService queteService, GameDatastore gameDatastore) {
        this.groupeDatastore = groupeDatastore;
        this.queteService = queteService;
        this.gameDatastore = gameDatastore;
    }

    @DeleteMapping
    public ResponseEntity<Object> reset() {
        this.groupeDatastore.reset();
        this.queteService.reset();
        this.gameDatastore.reset();
        return ResponseEntity.noContent().build();
    }

}
