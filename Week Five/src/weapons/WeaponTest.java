package weapons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weapons.exceptions.negativeInputException;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {
    Weapon testWeapon;
    @BeforeEach
    void init(){
        try {
            testWeapon = new Weapon("testWeapon", 5);
        } catch (negativeInputException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testGetDamage(){
        assertEquals(5, testWeapon.getDamage());
    }

    @Test
    void testSetDamage() {
        negativeInputException exception = assertThrows(negativeInputException.class, () -> {
            testWeapon.setDamage(-1);
        });

        String expectedMessage = "negative number input as damage: -1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

        assertEquals(5, testWeapon.getDamage());

        try {
            testWeapon.setDamage(2);
        } catch (negativeInputException e) {
        }
        assertEquals(2, testWeapon.getDamage());
    }

    @Test
    void testGetEffect() {
        assertEquals("no effect", testWeapon.getEffect());
    }

    @Test
    void testGetName() {
        assertEquals(null, testWeapon.getName());
    }

    @Test
    void testSetName() {
        assertEquals(null, testWeapon.getName());
        testWeapon.setName("longsword");
        assertEquals("longsword", testWeapon.getName());
    }
}
