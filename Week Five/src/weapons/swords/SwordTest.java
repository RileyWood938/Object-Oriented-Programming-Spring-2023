package weapons.swords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.exceptions.negativeInputException;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    Sword testingSword;
    @BeforeEach
    void init(){
        try {
            testingSword = new Sword("testingSword");
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testSword(){
        try {
            Sword testSword2 = new Sword("testSword2");
            assertEquals(testingSword.getDamage(), testSword2.getDamage());
            assertEquals(testingSword.printSword(), testSword2.printSword());

            Sword testSword3 = new Sword("testSword3", 3);
            assertNotEquals(testingSword.getDamage(), testSword3.getDamage());
            assertNotEquals(testingSword.printSword(), testSword3.printSword());
        }catch (negativeInputException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void testrollAttack() { //how the heck do you test something with random numbers?
    }

    @Test
    void testprintSword() {
        assertEquals(testingSword.printSword(), "Your sword has damage: 5");
    }

    @Test
    void testgetDamage() {
        assertEquals(testingSword.getDamage(), 5);
    }
}