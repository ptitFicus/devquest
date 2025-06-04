package fr.maif.devquest.hero_management.hero_manamgement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GroupeDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.GameDatastore;
import fr.maif.devquest.hero_management.hero_manamgement.datastore.QueteRepository;
import fr.maif.devquest.hero_management.hero_manamgement.model.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@Service
public class QueteService {
    private final QueteRepository queteRepository;
    private final GroupeDatastore groupeDatastore;
    private final GameDatastore gameDatastore;
    private Random random = new Random();
    private final ObjectMapper mapper;

    public QueteService(QueteRepository queteRepository, GroupeDatastore groupeDatastore, GameDatastore gameDatastore, ObjectMapper mapper) {
        this.queteRepository = queteRepository;
        this.groupeDatastore = groupeDatastore;
        this.gameDatastore = gameDatastore;
        this.mapper = mapper;
        this.queteRepository.createQuete(generateNewQuest());
        this.queteRepository.createQuete(generateNewQuest());
        this.queteRepository.createQuete(generateNewQuest());
    }

    public void setSeed(Long seed) {
        if(Objects.isNull(seed)) {
            this.random = new Random();
            return;
        }
        this.random = new Random(seed);
    }

    public List<Quete> readQuetes() {
        return queteRepository.readQuetes();
    }


    public ResultatQuete realiserQuete(String queteName) {
        Optional<Groupe> maybeGroupe = groupeDatastore.groupe;
        Optional<Quete> maybeQuete = queteRepository.readQuete(queteName);
        return maybeGroupe.flatMap(groupe -> {
            return maybeQuete.map(quete -> {
                var luck = random.nextInt(101);
                var memberCount = groupe.heros().size();
                boolean success = luck + quete.difficulte().basePercentage(memberCount) > 100;
                int deathCount = 0;
                if(success) {
                    int deathLuck = random.nextInt(101);
                    int deathDiff = deathLuck - quete.difficulte().basePercentage(memberCount);
                    deathCount = Math.max(0, Math.max(0, deathDiff / 20) - 1);
                    long reward = quete.difficulte().reward(memberCount - deathCount);
                    Set<String> deaths = mettreAJourLeGroupe(groupe, deathCount);

                    queteRepository.deleteQuete(queteName);
                    queteRepository.createQuete(generateNewQuest());
                    gameDatastore.deposit(reward);

                    return new ResultatQuete.SuccesQuete(queteName, deaths, reward);
                } else {
                    int diff = luck - quete.difficulte().basePercentage(memberCount);
                    deathCount = (diff / 20) + 1;
                    Set<String> deaths = mettreAJourLeGroupe(groupe, deathCount);
                    return new ResultatQuete.EchecQuete(queteName, deaths);
                }
            });
        }).orElseThrow(() -> new RuntimeException("Groupe ou quête inconnu(e)"));
    }

    private Set<String> mettreAJourLeGroupe(Groupe groupe, int deathCount) {
        if(deathCount > 0) {
            var newMembers = new ArrayList<>(groupe.heros());
            Set<String> deaths = new HashSet<>();
            for(int remainingToKill = deathCount; remainingToKill > 0 && !newMembers.isEmpty(); remainingToKill --) {
                var removedHero = newMembers.removeFirst();
                deaths.add(removedHero.name());
            }
            var newGroup = new Groupe(newMembers);
            groupeDatastore.saveGroupe(newGroup);
            return deaths;
        } else {
            return Collections.emptySet();
        }
    }

    private Quete generateNewQuest() {
        var questNames = loadQuestFile("questnames.json");
        var questLocations = loadQuestFile("questlocations.json");

        String name = questNames.get(random.nextInt(questNames.size()));
        String location = questLocations.get(random.nextInt(questLocations.size()));

        String questName =  name + " " + location;

        Difficulte diff = null;
        var diffRandom = random.nextInt(5);
        if (diffRandom == 0) {
            diff = Difficulte.FACILE;
        } else if(diffRandom == 1) {
            diff = Difficulte.MOYEN;
        } else if(diffRandom == 2) {
            diff = Difficulte.DIFFICILE;
        } else if(diffRandom == 3) {
            diff = Difficulte.EXTREME;
        } else {
            diff = Difficulte.IMPOSSIBLE;
        }

        return new Quete(questName, diff);
    }

    private List<String> loadQuestFile(String filename) {
        try {
            File resource = resource = new ClassPathResource(filename).getFile();
            var contentString = Files.readString(resource.toPath());
            return mapper.readValue(contentString, new TypeReference<List<String>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reset() {
        this.queteRepository.reset();
        this.queteRepository.createQuete(generateNewQuest());
        this.queteRepository.createQuete(generateNewQuest());
        this.queteRepository.createQuete(generateNewQuest());
    }


}
