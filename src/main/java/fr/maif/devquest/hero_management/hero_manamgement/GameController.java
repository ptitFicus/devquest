package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameInit;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final HeroDatastore heroDatastore;
    private final GroupeDatastore groupeDatastore;
    private GameDatastore gameDatastore;
    private QueteService queteService;

    public GameController(GameDatastore gameDatastore, QueteService queteService, HeroDatastore heroDatastore, GroupeDatastore groupeDatastore) {
        this.gameDatastore = gameDatastore;
        this.queteService = queteService;
        this.heroDatastore = heroDatastore;
        this.groupeDatastore = groupeDatastore;
    }

    @GetMapping
    public GameStatus readStatus() {
        return new GameStatus(gameDatastore.getName(), gameDatastore.remainingMoney());
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody GameInit gameInit) {
        gameDatastore.reset();
        gameDatastore.init(gameInit.name(), gameInit.seed());
        queteService.setSeed(gameInit.seed());
        queteService.reset();
        heroDatastore.reset();
        groupeDatastore.reset();


        return ResponseEntity.noContent().build();
    }
}
