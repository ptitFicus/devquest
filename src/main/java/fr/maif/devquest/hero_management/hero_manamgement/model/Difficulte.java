package fr.maif.devquest.hero_management.hero_manamgement.model;

public enum Difficulte {
    FACILE(50, 100, 10),
    MOYEN(30, 300, 8),
    DIFFICILE(20, 600, 6),
    EXTREME(10, 5_000, 3),
    IMPOSSIBLE(5, 10_000, 1);

    public int probabailiteSucces;
    public long recompenseDeBase;
    public int augmentationDeProbabiliteParMembre;

    Difficulte(int probabailiteSucces, long recompenseDeBase, int augmentationDeProbabiliteParMembre) {
        this.probabailiteSucces = probabailiteSucces;
        this.recompenseDeBase = recompenseDeBase;
        this.augmentationDeProbabiliteParMembre = augmentationDeProbabiliteParMembre;
    }

    public int basePercentage(int memberCount) {
        return probabailiteSucces + memberCount * augmentationDeProbabiliteParMembre;
    }

    public long reward(int memberCount) {
        return recompenseDeBase + (augmentationDeProbabiliteParMembre * recompenseDeBase/100) * memberCount;
    }

}
