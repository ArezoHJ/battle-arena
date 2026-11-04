package model;

public class Warrior extends CharacterRole{

    public Warrior(){
        super();
        this.setName("Warrior");
        this.setMaxHp(120);
        this.setCurrentHp( this.getMaxHp());
        this.setSpecialAbility(ActionType.DEFENCE);
    }

    public int attack(){
        // skriv någonting
        return 0;
    }

    public void takeDamage(int damage){
        // skriv någonting

    }
    public int useAbility(){
        // skriv någonting
        return 0;
    }
}
