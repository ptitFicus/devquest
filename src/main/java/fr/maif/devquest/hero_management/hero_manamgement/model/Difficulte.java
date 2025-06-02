package fr.maif.devquest.hero_management.hero_manamgement.model;

public enum Difficulte {
    FACILE(50, 100, 10),
    MOYEN(40, 300, 9),
    DIFFICILE(30, 600, 7),
    EXTREME(20, 5_000, 5),
    IMPOSSIBLE(10, 10_000, 3);

    public int probabailiteSucces;
    public long recompenseDeBase;
    public int augmentationDeProbabiliteParMembre;

    Difficulte(int probabailiteSucces, long recompenseDeBase, int augmentationDeProbabiliteParMembre) {
        this.probabailiteSucces = probabailiteSucces;
        this.recompenseDeBase = recompenseDeBase;
        this.augmentationDeProbabiliteParMembre = augmentationDeProbabiliteParMembre;
    }

    public int percentageToReach(int memberCount) {
        return 100 - (probabailiteSucces + memberCount * augmentationDeProbabiliteParMembre);
    }

    public int deathProbabaility(int memberCount) {
        return 100 - percentageToReach(memberCount);
    }

    public long reward(int memberCount) {
        return recompenseDeBase + (augmentationDeProbabiliteParMembre * recompenseDeBase/100) * memberCount;
    }

}
