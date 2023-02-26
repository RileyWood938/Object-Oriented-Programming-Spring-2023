package package1;

import special.Attack;

public class BowTestCode {
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
}
