package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.model.Quete;
import fr.maif.devquest.hero_management.hero_manamgement.model.ResultatQuete;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quetes")
public class QueteController {
    private final QueteService queteService;

    public QueteController(QueteService queteService) {
        this.queteService = queteService;
    }

    @GetMapping
    public List<Quete> readQuetes() {
        return queteService.readQuetes();
    }

    @PostMapping("/{quete}/_commencer")
    public ResultatQuete realiserQuete(@PathVariable("quete") String quete)  {
        return queteService.realiserQuete(quete);
    }
}
