package model;

public class Warrior extends Character {
    private static final int MIN_ATTACK_DAMAGE = 5;
    private static final int MAX_ATTACK_DAMAGE = 15;
    private boolean defending;

    public Warrior(String name) {
        super(name, 120);
    }

    @Override
    public int attack() {
        return randomDamage(MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE);
    }

    @Override
    protected void activateSpecialAbility(Character target) {
        defending = true;
    }

    @Override
    protected int reduceIncomingDamage(int damage) {
        if (!defending) {
            return damage;
        }
        defending = false;
        return damage / 2;
    }
}
