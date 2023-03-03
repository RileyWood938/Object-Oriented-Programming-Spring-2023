//package weapons.swords;
//
//import weapons.Attack;
//
///**
// * <p>code to test the functionality of the Weapons.Sword and Weapons.MagicSword classes</p>
// * <p>prints natural language results of the attacks with each Weapons.Sword</p>
// * @author Riley Wood
// */
//public class SwordTestCode {
//    /**
//     * <p>Test code for the Weapons.Sword parent class</p>
//     * <p>iterates through different Weapons.Sword stat combinations (damage) and prints results for each of them</p>
//     * <p>Prints directly to console rather than having any return</p>
//     */
//    public void testSword(){
//        for (int i = 0; i <= 3; i++) {
//            Sword newSword = new Sword(i);
//            newSword.printSword();
//            System.out.println("you attacked an enemy");
//            Attack tempAttack = newSword.rollAttack(10, 7*i);
//            System.out.println(tempAttack.printAttack());
//            System.out.println("");
//        }
//    }
//    /**
//     * <p>Test code for the Weapons.MagicSword subclass</p>
//     * <p>iterates through different Weapons.Sword stat combinations (damage, effect) and prints results for each of them</p>
//     * <p>Prints directly to console rather than having any return</p>
//     */
//    public void testMagicSword(){
//        for (int i = 0; i <= 3; i++) {
//            MagicSword newSword = new MagicSword(i, 5*i);
//            newSword.printSword();
//            System.out.println("you attacked an enemy");
//            Attack tempAttack = newSword.rollAttack(10, 7*i);
//            System.out.println(tempAttack.printAttack());
//            System.out.println("");
//        }
//    }
//}