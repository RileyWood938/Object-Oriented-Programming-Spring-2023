package weapons.swords;

import weapons.Attack;
import weapons.exceptions.negativeInputException;


public class SwordTestCode {

    public void testSword() {
        Sword sword = null;

        try {
            sword = new Sword("sword");
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }

        sword.setName("experiement Sword");
        System.out.println(sword.printSword());
        Attack attack1 = sword.rollAttack(10, 2, 1);
        System.out.println(attack1.printAttack());
    }
}