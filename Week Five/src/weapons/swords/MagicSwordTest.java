package weapons.swords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.exceptions.negativeInputException;

import static org.junit.jupiter.api.Assertions.*;

class MagicSwordTest {
    MagicSword testingSword;
    @BeforeEach
    void init(){
        try {
            testingSword = new MagicSword("testingSword","fire");
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    void testRollAttack() {
    }

    @Test
    void testPrintSword() {
        assertEquals("Your sword has damage: 5 and the effect: fire", testingSword.printSword());

    }

    @Test
    void getSwordEffect() {
        assertEquals("fire", testingSword.getSwordEffect());
    }
}