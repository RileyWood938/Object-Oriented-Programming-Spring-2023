package weapons.swords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
    Sword testingSword;
    @BeforeEach
    void init(){
        testingSword = new Sword();
    }
    @Test
    void testSword(){
        Sword testSword2 = new Sword();
        assertEquals(testingSword.getDamage(), testSword2.getDamage());
        assertEquals(testingSword.printSword(), testSword2.printSword());

        Sword testSword3 = new Sword(3);
        assertNotEquals(testingSword.getDamage(), testSword3.getDamage());
        assertNotEquals(testingSword.printSword(), testSword3.printSword());
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