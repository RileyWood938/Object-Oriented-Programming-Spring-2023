package package1;

import special.Attack;
import java.lang.Math;

/**
 * <p>Code for the Bow parent class</p>
 * <p>stores a range and damage, and has methods to roll an attack against a given foe's armor class</p>
 */
public class Bow {
    int damage;
    int range;

    public Bow(){
        this.damage = 5;
        this.range = 30;
    }
    public Bow(int damage){
        this.damage = damage;
        this.range = 30;
    }
    public Bow(int damage, int range){
        this.damage = damage;
        this.range = range;
    }

    /**v
     * <p>method to roll an attack against an opponent</p>
     * <p>generates a number 1-20 and adds player attack modifier. Compares this with armor class to see if result is
     * hit or miss. Also checks bow's max range against distance to foe.</p>
     * @param distance takes distance from user to foe
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an Attack (see Attack class)
     */
    public Attack rollAttack(int distance, int armorClass, int attackModifier){
        int randomRoll = (int) Math.ceil(Math.random() * 20);
        String hitResult;

        if(distance<= this.range && randomRoll+attackModifier >= armorClass){
            hitResult = "Hit";
        }else{
            hitResult = "Miss";
        }

        Attack tempAttack = new Attack(this.damage, hitResult);
        System.out.println("you rolled a " + randomRoll + " + " + attackModifier + " = " + (randomRoll+attackModifier) + ". The enemy armor class is: " + armorClass + " giving you a result of " + hitResult);
        return tempAttack;
    }

    /**
     * method to print information on the bow.
     * <p>throws an arrayout of bounds exception about 1/4 times it is run. This was implemented to practice
     * try/catch/throw. Obviouslyt this is not the intended use, as array index out of bounds is a logical error and
     * thus not one which should be handled by try/catch. This was purely added as proof of concept for throwing errors
     * up to the cal;lign function and catching them there.</p>
     * @throws ArrayIndexOutOfBoundsException
     */
    public void printBow() throws ArrayIndexOutOfBoundsException
    {
        int[] integerarray = {0};
        if(Math.ceil(Math.random() * 20)<5){
            integerarray[5] = 1;
        }
        System.out.println("Your Bow has damage: "+ damage + " and range: " + range);
    }
}
