package package2;

import package2.Sword;
import package2.MagicSword;
import special.Attack;
/**
 * <p>code to test the functionality of the Sword and MagicSword classes</p>
 * <p>prints natural language results of the attacks with each Sword</p>
 * @author Riley Wood
 */
public class SwordTestCode {
    /**
     * <p>Test code for the Sword parent class</p>
     * <p>iterates through different Sword stat combinations (damage) and prints results for each of them</p>
     * <p>Prints directly to console rather than having any return</p>
     */
    public void testSword(){
        for (int i = 0; i <= 3; i++) {
            Sword newSword = new Sword(i);
            newSword.printSword();
            System.out.println("you attacked an enemy");
            Attack tempAttack = newSword.rollAttack(10, 7*i);
            System.out.println(tempAttack.printAttack());
            System.out.println("");
        }
    }
    /**
     * <p>Test code for the MagicSword subclass</p>
     * <p>iterates through different Sword stat combinations (damage, effect) and prints results for each of them</p>
     * <p>Prints directly to console rather than having any return</p>
     */
    public void testMagicSword(){
        for (int i = 0; i <= 3; i++) {
            MagicSword newSword = new MagicSword(i, 5*i);
            newSword.printSword();
            System.out.println("you attacked an enemy");
            Attack tempAttack = newSword.rollAttack(10, 7*i);
            System.out.println(tempAttack.printAttack());
            System.out.println("");
        }
    }
}