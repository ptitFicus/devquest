package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.exceptions.InvalidHeroException;
import fr.maif.devquest.hero_management.hero_manamgement.model.Hero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

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

    @PostMapping
    public ResponseEntity<Object> createHero(@RequestBody Hero hero) {
        if(Objects.isNull(hero.name()) || hero.name().isBlank()) {
            throw new InvalidHeroException();
        }

        if(Objects.isNull(hero.role())) {
            throw new InvalidHeroException();
        }

        if(Objects.isNull(hero.achievements())) {
            throw new InvalidHeroException();
        }
        heroDatastore.createHero(hero);
        return ResponseEntity.noContent().build();
    }
}
