package weapons.bows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.Weapon;
import weapons.exceptions.negativeInputException;
import weapons.swords.Sword;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {

    Bow testingBow;
    @BeforeEach
    void init(){
        try {
            testingBow = new Bow("testingBow");
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testBow(){
        try {

            Bow testBow2 = new Bow("testBow2");
            assertEquals(testingBow.getDamage(), testBow2.getDamage());
            assertEquals(testingBow.getRange(), testBow2.getRange());
            assertEquals(testingBow.printBow(), testBow2.printBow());

            Bow testBow3 = new Bow("testBow3", 3);
            assertNotEquals(testingBow.getDamage(), testBow3.getDamage());
            assertEquals(testingBow.getRange(), testBow3.getRange());
            assertNotEquals(testingBow.printBow(), testBow3.printBow());

            Bow testBow4 = new Bow("testBow4", 5, 5);
            assertEquals(testingBow.getDamage(), testBow4.getDamage());
            assertNotEquals(testingBow.getRange(), testBow4.getRange());
            assertNotEquals(testingBow.printBow(), testBow4.printBow());

        }catch (negativeInputException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRollAttack() {
    }

    @Test
    void testRollAttack1() {
    }

    @Test
    void printBow() {
        assertEquals("Your Bow has damage: 5 and range: 30", testingBow.printBow());
    }
}