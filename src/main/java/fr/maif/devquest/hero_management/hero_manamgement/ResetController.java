package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/_reset")
public class ResetController {
    private final GroupeDatastore groupeDatastore;
    private final QueteService queteService;

    public ResetController(GroupeDatastore groupeDatastore, QueteService queteService) {
        this.groupeDatastore = groupeDatastore;
        this.queteService = queteService;
    }

    @DeleteMapping
    public ResponseEntity<Object> reset() {
        this.groupeDatastore.reset();
        this.queteService.reset();
        return ResponseEntity.noContent().build();
    }

}
