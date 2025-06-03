package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.MoneyDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Quete;
import fr.maif.devquest.hero_management.hero_manamgement.model.ResultatQuete;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quetes")
public class QueteController {
    private final QueteService queteService;
    private final MoneyDatastore moneyDatastore;

    public QueteController(QueteService queteService, MoneyDatastore moneyDatastore) {
        this.queteService = queteService;
        this.moneyDatastore = moneyDatastore;
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
        moneyDatastore.withdraw(1000);
        queteService.reset();
        return queteService.readQuetes();
    }
}
