package weapons.swords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicSwordTest extends Sword {
    Sword testingSword;

    @BeforeEach
    void init(){
        testingSword = new MagicSword("fire");
    }
    @Test
    void testMagicSword(){
        Sword testSword2 = new MagicSword("fire");
        assertEquals(testSword2.printSword(), testingSword.printSword());
        assertEquals(testSword2.getDamage(), testingSword.getDamage());
        assertEquals(testSword2.getSwordEffect(), testingSword.getSwordEffect());

        testSword2 = new MagicSword(5,"fire");
        assertEquals(testSword2.printSword(), testingSword.printSword());
        assertEquals(testSword2.getDamage(), testingSword.getDamage());
        assertEquals(testSword2.getSwordEffect(), testingSword.getSwordEffect());
    }
    @Test
    void testRollAttack() {
    }

    @Test
    void testPrintSword() {
    }


    @Test
    void testGetSwordEffect() {
        assertEquals(testingSword.getSwordEffect(), "fire");
    }
}