package fr.maif.devquest.hero_management.hero_manamgement.model;

public enum Difficulte {
    FACILE(50, 100, 10, 1),
    MOYEN(30, 300, 8, 2),
    DIFFICILE(20, 600, 6, 3),
    EXTREME(10, 5_000, 3, 4),
    IMPOSSIBLE(5, 10_000, 1, 5);

    public int probabailiteSucces;
    public long recompenseDeBase;
    public int augmentationDeProbabiliteParMembre;
    public int score;

    Difficulte(int probabailiteSucces, long recompenseDeBase, int augmentationDeProbabiliteParMembre, int score) {
        this.probabailiteSucces = probabailiteSucces;
        this.recompenseDeBase = recompenseDeBase;
        this.augmentationDeProbabiliteParMembre = augmentationDeProbabiliteParMembre;
        this.score = score;
    }

    public int basePercentage(int memberCount) {
        return probabailiteSucces + memberCount * augmentationDeProbabiliteParMembre;
    }

    public long reward(int memberCount) {
        return recompenseDeBase + (augmentationDeProbabiliteParMembre * recompenseDeBase/100) * memberCount;
    }

}
