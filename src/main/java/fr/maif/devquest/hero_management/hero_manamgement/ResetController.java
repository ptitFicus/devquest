package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.MoneyDatastore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/_reset")
public class ResetController {
    private final GroupeDatastore groupeDatastore;
    private final QueteService queteService;
    private final MoneyDatastore moneyDatastore;

    public ResetController(GroupeDatastore groupeDatastore, QueteService queteService, MoneyDatastore moneyDatastore) {
        this.groupeDatastore = groupeDatastore;
        this.queteService = queteService;
        this.moneyDatastore = moneyDatastore;
    }

    @DeleteMapping
    public ResponseEntity<Object> reset() {
        this.groupeDatastore.reset();
        this.queteService.reset();
        this.moneyDatastore.reset();
        return ResponseEntity.noContent().build();
    }

}
