package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Quete;
import fr.maif.devquest.hero_management.hero_manamgement.model.ResultatQuete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quetes")
public class QueteController {
    private final QueteService queteService;
    private final GameDatastore gameDatastore;

    public QueteController(QueteService queteService, GameDatastore gameDatastore) {
        this.queteService = queteService;
        this.gameDatastore = gameDatastore;
    }

    @GetMapping
    public List<Quete> readQuetes() {
        return queteService.readQuetes();
    }

    @PostMapping("/{quete}/_commencer")
    public ResultatQuete realiserQuete(@PathVariable("quete") String quete)  {
        return queteService.realiserQuete(quete);
    }

    @PostMapping("/_reroll")
    public List<Quete> rerollQuetes() {
        gameDatastore.withdraw(1000);
        queteService.reset();
        return queteService.readQuetes();
    }
}
