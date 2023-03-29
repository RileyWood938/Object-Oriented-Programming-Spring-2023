package weapons.bows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.exceptions.negativeInputException;
import weapons.swords.MagicSword;

import static org.junit.jupiter.api.Assertions.*;

class MagicBowTest {

    MagicBow testingBow;
    @BeforeEach
    void init(){
        try {
            testingBow = new MagicBow("testingBow", 5, 30, "fire");
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }
    }

    void testBow(){
        try {
            MagicBow testBow1 = new MagicBow("testBow1");
            MagicBow testBow2 = new MagicBow("testBow2", 4);
            MagicBow testBow3 = new MagicBow("testBow3", 3, 25);
            MagicBow testBow4 = new MagicBow("testBow4", 2, 20, "ice");

            assertEquals(testingBow.printBow(), testBow1.printBow());
            assertNotEquals(testingBow.printBow(), testBow2.printBow());
            assertNotEquals(testingBow.printBow(), testBow3.printBow());
            assertNotEquals(testingBow.printBow(), testBow4.printBow());

        }catch (negativeInputException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRollAttack() {
    }

    @Test
    void testPrintBow() {
        assertEquals("Your Bow has damage: 5 and range: 30 and the effect: fire", testingBow.printBow());
    }

}