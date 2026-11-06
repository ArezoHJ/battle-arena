package model;

import java.util.Objects;

public abstract class Character implements SpecialAbility {
    private final String name;
    private final int maxHp;
    private int hp;
    private boolean specialAbilityUsed;

    protected Character(String name, int maxHp) {
        this.name = Objects.requireNonNull(name, "name");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("Maximum HP must be positive");
        }
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        hp = Math.max(0, hp - reduceIncomingDamage(damage));
    }

    protected int reduceIncomingDamage(int damage) {
        return damage;
    }

    protected final void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Healing cannot be negative");
        }
        hp = Math.min(maxHp, hp + amount);
    }

    protected static int randomDamage(int minimum, int maximum) {
        return java.util.concurrent.ThreadLocalRandom.current()
                .nextInt(minimum, maximum + 1);
    }

    @Override
    public final void useSpecialAbility(Character target) {
        Objects.requireNonNull(target, "target");
        if (specialAbilityUsed) {
            throw new IllegalStateException("Special ability has already been used");
        }
        specialAbilityUsed = true;
        activateSpecialAbility(target);
    }

    protected abstract void activateSpecialAbility(Character target);

    public abstract int attack();
}
