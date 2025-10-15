package fr.maif.devquest.hero_management.hero_manamgement;

import fr.maif.devquest.hero_management.hero_manamgement.datastore.HeroDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.exceptions.InvalidHeroException;
import fr.maif.devquest.hero_management.hero_manamgement.model.Hero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/api/heros")
public class HeroController {
    private HeroDatastore heroDatastore;
    private boolean isOff;

    public HeroController(HeroDatastore heroDatastore, @Value("${nobackend}") Boolean isOff) {
        this.heroDatastore = heroDatastore;
        this.isOff = isOff;
    }

    @GetMapping
    public Collection<Hero> readHeros() {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
        return heroDatastore.heros;
    }

    @PostMapping
    public ResponseEntity<Object> createHero(@RequestBody Hero hero) {
        if(isOff) {
            throw new RuntimeException("Backend is disabled, change value of \"nobackend\" property to enabled it.");
        }
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
