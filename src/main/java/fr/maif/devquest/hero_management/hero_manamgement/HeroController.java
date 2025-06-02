package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.model.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/heros")
public class HeroController {
    private HeroDatastore heroDatastore;

    public HeroController(HeroDatastore heroDatastore) {
        this.heroDatastore = heroDatastore;
    }

    @GetMapping
    public Collection<Hero> readHeros() {
        return heroDatastore.heros;
    }
}
