package model;

public abstract class CharacterRole implements SpecialAbility {
    private String name;
    private int currentHp;
    private int maxHp;
    private ActionType normalAbility;
    private ActionType specialAbility;
    private int numberOfUseSpecialAbility;

    public CharacterRole() {
        this.normalAbility = ActionType.ATTACK;
        this.numberOfUseSpecialAbility = 1;
    }

    public abstract int attack();
    public abstract void takeDamage( int damage );
    public boolean isAlive(){
        return 0 < currentHp;
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public ActionType getNormalAbility() {
        return normalAbility;
    }

    public void setNormalAbility(ActionType normalAbility) {
        this.normalAbility = normalAbility;
    }

    public ActionType getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(ActionType specialAbility) {
        this.specialAbility = specialAbility;
    }

    public int getNumberOfUseSpecialAbility() {
        return numberOfUseSpecialAbility;
    }

    public void setNumberOfUseSpecialAbility(int numberOfUseSpecialAbility) {
        this.numberOfUseSpecialAbility = numberOfUseSpecialAbility;
    }
}
