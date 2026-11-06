package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {
    @Test
    void actionTypeAttack() {
        ActionType actionType = ActionType.ATTACK;

        assertEquals(ActionType.ATTACK, actionType);
    }

    @Test
    void actionTypeSpecial() {
        ActionType actionType = ActionType.SPECIAL;

        assertEquals(ActionType.SPECIAL, actionType);
    }

    @Test
    void takingDamageReducesHp() {
        Character warrior = new Warrior("Test");

        warrior.takeDamage(30);

        assertEquals(90, warrior.getHp());
    }

    @Test
    void damageCannotReduceHpBelowZero() {
        Character mage = new Mage("Test");

        mage.takeDamage(100);

        assertEquals(0, mage.getHp());
    }

    @Test
    void mageHealsByFifteen() {
        Mage mage = new Mage("Test");
        mage.takeDamage(20);

        mage.useSpecialAbility(mage);

        assertEquals(85, mage.getHp());
    }

    @Test
    void mageHealingCannotExceedMaximumHp() {
        Mage mage = new Mage("Test");
        mage.takeDamage(5);

        mage.useSpecialAbility(mage);

        assertEquals(90, mage.getHp());
    }

    @Test
    void warriorDefendHalvesTheNextDamageAndRoundsDown() {
        Warrior warrior = new Warrior("Test");
        warrior.useSpecialAbility(warrior);

        warrior.takeDamage(11);

        assertEquals(115, warrior.getHp());
    }

    @Test
    void warriorDefendOnlyAffectsOneIncomingAttack() {
        Warrior warrior = new Warrior("Test");
        warrior.useSpecialAbility(warrior);
        warrior.takeDamage(10);
        warrior.takeDamage(10);

        assertEquals(105, warrior.getHp());
    }

    @Test
    void specialAbilityCanOnlyBeUsedOnce() {
        Mage mage = new Mage("Test");
        mage.takeDamage(20);
        mage.useSpecialAbility(mage);

        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalStateException.class,
                () -> mage.useSpecialAbility(mage)
        );
    }

    @Test
    void rangerAttackIsWithinItsDefinedRange() {
        Ranger ranger = new Ranger("Test");

        for (int i = 0; i < 100; i++) {
            int damage = ranger.attack();
            org.junit.jupiter.api.Assertions.assertTrue(damage >= 6 && damage <= 16);
        }
    }

    @Test
    void rangerSpecialDealsDamageWithinItsDefinedRange() {
        Ranger ranger = new Ranger("Test");
        Character target = new Mage("Target");
        int hpBefore = target.getHp();

        ranger.useSpecialAbility(target);

        int damage = hpBefore - target.getHp();
        org.junit.jupiter.api.Assertions.assertTrue(damage >= 12 && damage <= 20);
    }
}

