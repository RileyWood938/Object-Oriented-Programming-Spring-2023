package mainPackage;
import package1.BowTestCode;
import package2.SwordTestCode;

/**
 * <p>main class</p>
 * <p>exists to call testing functionality from other classes</p>
 */
public class Main {
    public static void main(String[] args) {
        BowTestCode bowTester = new BowTestCode();
        bowTester.testBow();
        bowTester.testMagicBow();
        SwordTestCode swordTester = new SwordTestCode();
        swordTester.testSword();
        swordTester.testMagicSword();
    }
}