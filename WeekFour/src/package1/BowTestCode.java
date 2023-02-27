package package1;

import special.Attack;

/**
 * <p>code to test the functionality of the Bow and MagicBow classes</p>
 * <p>prints natural language results of the attacks with each bow</p>
 * @author Riley Wood
 */
public class BowTestCode {
    /**
     * <p>Test code for the Bow parent class</p>
     * <p>iterates through different bow stat combinations (range, damage) and prints results for each of them</p>
     * <p>Prints directly to console rather than having any return</p>
     */
    public void testBow(){
        for (int i = 0; i <= 3; i++) {
            Bow newBow = new Bow(i, 5*i);
            newBow.printBow();
            System.out.println("you attacked an enemy " + "10" + " meters away.");
            Attack tempAttack = newBow.rollAttack(10, 7*i, 2*i);
            System.out.println(tempAttack.printAttack());
            System.out.println("");
        }
    }
    /**
     * <p>Test code for the MagicBow subclass</p>
     * <p>iterates through different bow stat combinations (range, damage, effect) and prints results for each of them</p>
     * <p>Prints directly to console rather than having any return</p>
     */
    public void testMagicBow(){
        for (int i = 0; i <= 3; i++) {
            MagicBow newBow = new MagicBow(i, 5*i);
            newBow.printBow();
            System.out.println("you attacked an enemy " + "10" + " meters away.");
            Attack tempAttack = newBow.rollAttack(10, 7*i, 2*i);
            System.out.println(tempAttack.printAttack());
            System.out.println("");
        }
    }
}
