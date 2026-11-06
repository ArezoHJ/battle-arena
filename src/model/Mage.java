package model;

public class Mage extends Character {
    private static final int MIN_ATTACK_DAMAGE = 8;
    private static final int MAX_ATTACK_DAMAGE = 18;

    public Mage(String name) {
        super(name, 90);
    }

    @Override
    protected void activateSpecialAbility(Character target) {
        heal(15);
    }

    @Override
    public int attack() {
        return randomDamage(MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE);
    }
}
