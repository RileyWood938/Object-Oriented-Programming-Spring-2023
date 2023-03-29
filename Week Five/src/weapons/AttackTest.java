package weapons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {
    Attack testAttack;
    Attack testMagicAttack;
    @BeforeEach
    void init(){
        testAttack = new Attack(2, 10, 5, 1, 1);
        testMagicAttack = new Attack(2, 10, 5, 1, 1, "fire");
    }

    @Test
    void getDamage() {
        assertEquals(5,testAttack.getDamage());
    }

    @Test
    void getHitResult() {
        //no clue here
    }

    @Test
    void getEffect() {
        assertEquals("no effect", testAttack.getEffect());
        assertEquals("fire", testMagicAttack.getEffect());

    }

    @Test
    void setEffect() {
        testAttack.setEffect("fire");
        assertEquals("fire", testAttack.getEffect());
        testMagicAttack.setEffect("ice");
        assertEquals("ice", testMagicAttack.getEffect());
    }

    @Test
    void printAttack() {
        //again no clue here
    }
}