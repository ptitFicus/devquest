package fr.maif.devquest.hero_management.hero_manamgement.datastore;

import org.springframework.stereotype.Repository;

@Repository
public class GameDatastore {
    private long amount = 10_000;
    private String name;
    private Long seed;

    public long remainingMoney() {
        return amount;
    }

    public long deposit(long amount) {
        this.amount += amount;
        return this.amount;
    }

    public long withdraw(long amount) {
        var newAmount = this.amount - amount;
        if(newAmount < 0) {
            throw new RuntimeException("Pas assez d'argent");
        }
        this.amount -= amount;
        return this.amount;
    }

    public void reset() {
        amount = 10_000;
        name = null;
        seed = null;
    }

    public void init(String name, Long seed) {
        this.name = name;
        this.seed = seed;
    }

    public String getName() {
        return name;
    }
}
