package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.MoneyDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.GameStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private MoneyDatastore moneyDatastore;

    public GameController(MoneyDatastore moneyDatastore) {
        this.moneyDatastore = moneyDatastore;
    }

    @GetMapping
    public GameStatus readStatus() {
        return new GameStatus(moneyDatastore.remainingMoney());
    }
}
