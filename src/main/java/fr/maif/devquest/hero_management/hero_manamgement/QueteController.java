package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Quete;
import fr.maif.devquest.hero_management.hero_manamgement.model.ResultatQuete;
import fr.maif.devquest.hero_management.hero_manamgement.model.ResultatQueteOut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quetes")
public class QueteController {
    private final QueteService queteService;
    private final GameDatastore gameDatastore;
    private final boolean isOff;

    public QueteController(QueteService queteService, GameDatastore gameDatastore,  @Value("${nobackend}") Boolean isOff) {
        this.queteService = queteService;
        this.gameDatastore = gameDatastore;
        this.isOff = isOff;
    }

    @GetMapping
    public List<Quete> readQuetes() {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        return queteService.readQuetes();
    }

    @PostMapping("/{quete}/_commencer")
    public ResultatQueteOut realiserQuete(@PathVariable("quete") String quete)  {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        return queteService.realiserQuete(quete);
    }

    @PostMapping("/_reroll")
    public List<Quete> rerollQuetes() {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        gameDatastore.withdraw(1000);
        queteService.reset();
        return queteService.readQuetes();
    }
}
