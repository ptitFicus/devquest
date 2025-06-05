package fr.maif.devquest.hero_management.hero_manamgement.datastore;

import org.springframework.stereotype.Repository;

@Repository
public class GameDatastore {
    private long amount = 10_000;
    private String name;
    private long score = 0;

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
        this.score = 0;
    }

    public void init(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public long incrementScore(long scoreToAdd) {
        this.score += scoreToAdd;
        return this.score;
    }

    public long readScore() {
        return this.score;
    }
}
