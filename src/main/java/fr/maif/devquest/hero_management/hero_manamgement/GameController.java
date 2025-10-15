package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameInit;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final HeroDatastore heroDatastore;
    private final GroupeDatastore groupeDatastore;
    private GameDatastore gameDatastore;
    private QueteService queteService;
    private boolean isOff;

    public GameController(
            GameDatastore gameDatastore,
            QueteService queteService,
            HeroDatastore heroDatastore,
            GroupeDatastore groupeDatastore,
            @Value("${nobackend}") Boolean isOff) {
        this.gameDatastore = gameDatastore;
        this.queteService = queteService;
        this.heroDatastore = heroDatastore;
        this.groupeDatastore = groupeDatastore;
        this.isOff = isOff;
    }

    @GetMapping
    public GameStatus readStatus() {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        return new GameStatus(gameDatastore.getName(), gameDatastore.remainingMoney(), gameDatastore.readScore());
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody GameInit gameInit) {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        gameDatastore.reset();
        gameDatastore.init(gameInit.name());
        queteService.setSeed(gameInit.seed());
        queteService.reset();
        heroDatastore.reset();
        groupeDatastore.reset();


        return ResponseEntity.noContent().build();
    }
}
