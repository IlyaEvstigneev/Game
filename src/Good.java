public enum Good {
    POTION_OF_LIFE(50,10, 0, 0, 0, 0, "Зелье жизни"),
    POTIOM_OF_XP(50, 0, 100, 0, 0,0, "Баночка опыта"),
    SWORD(400, 0, 0, 15,0,0, "Меч"), //меч
    SHILD(300, 0, 0, 0,25,0, "Щит"), //щит
    ARMOR(280, 0, 0, 0,0,12, "Броня");  //броня

    int cash;
    int treatment;
    int theExperienceGained;
    int increasedDamage;
    int increasedLife;
    int increasedDexterity;
    String nameForRussian;

    Good(int cash, int treatment, int theExperienceGained, int increasedDamage, int increasedLife, int increasedDexterity, String nameForRussian) {
        this.cash = cash;
        this.treatment = treatment;
        this.theExperienceGained = theExperienceGained;
        this.increasedDamage = increasedDamage;
        this.increasedLife = increasedLife;
        this.increasedDexterity = increasedDexterity;
        this.nameForRussian = nameForRussian;
    }

    public int getCash(){
        return cash;
    }

    public int getTreatment() {
        return treatment;
    }

    public int getTheExperienceGained() {
        return theExperienceGained;
    }

    public int getIncreasedDamage() {
        return increasedDamage;
    }

    public int getIncreasedLife() {
        return increasedLife;
    }

    public int getIncreasedDexterity() {
        return increasedDexterity;
    }

    public String getNameForRussian() {
        return nameForRussian;
    }

    @Override
    public String toString() {
        return getNameForRussian();
    }
}

