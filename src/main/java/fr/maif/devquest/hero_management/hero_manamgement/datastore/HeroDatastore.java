package fr.maif.devquest.hero_management.hero_manamgement.datastore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.maif.devquest.hero_management.hero_manamgement.Data;
import fr.maif.devquest.hero_management.hero_manamgement.exceptions.InvalidHeroException;
import fr.maif.devquest.hero_management.hero_manamgement.model.Groupe;
import fr.maif.devquest.hero_management.hero_manamgement.model.Hero;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

@Repository
public class HeroDatastore {
    public Deque<Hero> heros = new LinkedList<>();
    private ObjectMapper mapper;

    private Deque<Hero> readHerosFromFile() throws IOException {
        return mapper.readValue(Data.HEROES, new TypeReference<Deque<Hero>>() {});
    }


    public HeroDatastore(ObjectMapper mapper) throws IOException {
        this.mapper = mapper;
        this.heros = readHerosFromFile();
    }

    public void createHero(Hero hero) {
        var exist = heros.stream().anyMatch(h -> h.name().equals(hero.name()));
        if(exist) {
            throw new InvalidHeroException();
        }
        heros.addFirst(hero);
    }

    public void reset() {
        try {
            this.heros = readHerosFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
