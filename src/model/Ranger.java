package model;

public class Ranger extends Character {
    private static final int MIN_ATTACK_DAMAGE = 6;
    private static final int MAX_ATTACK_DAMAGE = 16;
    private static final int MIN_SPECIAL_DAMAGE = 12;
    private static final int MAX_SPECIAL_DAMAGE = 20;

    public Ranger(String name) {
        super(name, 105);
    }

    @Override
    protected void activateSpecialAbility(Character target) {
        target.takeDamage(randomDamage(MIN_SPECIAL_DAMAGE, MAX_SPECIAL_DAMAGE));
    }

    @Override
    public int attack() {
        return randomDamage(MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE);
    }
}
