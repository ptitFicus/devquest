package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameInit;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final HeroDatastore heroDatastore;
    private GameDatastore gameDatastore;
    private QueteService queteService;

    public GameController(GameDatastore gameDatastore, QueteService queteService, HeroDatastore heroDatastore) {
        this.gameDatastore = gameDatastore;
        this.queteService = queteService;
        this.heroDatastore = heroDatastore;
    }

    @GetMapping
    public GameStatus readStatus() {
        return new GameStatus(gameDatastore.getName(), gameDatastore.remainingMoney());
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody GameInit gameInit) {
        gameDatastore.init(gameInit.name(), gameInit.seed());
        queteService.setSeed(gameInit.seed());
        queteService.reset();

        return ResponseEntity.noContent().build();
    }
}
