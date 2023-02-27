package package2;

import special.Attack;
import java.lang.Math;
/**
 * <p>Code for the Sword parent class</p>
 * <p>stores a damage stat, and has methods to roll an attack against a given foe's armor class</p>
 */
public class Sword {
    int damage;

    public Sword(){
        this.damage = 5;
    }
    public Sword(int damage){
        this.damage = damage;
    }

    /**
     * <p>method to roll an attack against an opponent</p>
     * <p>generates a number 1-20 and adds player attack modifier. Compares this with armor class to see if result is
     * hit or miss.</p>
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an Attack (see Attack class)
     */
    public Attack rollAttack(int armorClass, int attackModifier){
        int randomRoll = (int) Math.ceil(Math.random() * 20);
        String hitResult;

        if(randomRoll+attackModifier >= armorClass){
            hitResult = "Hit";
        }else{
            hitResult = "Miss";
        }

        Attack tempAttack = new Attack(this.damage, hitResult);
        System.out.println("you rolled a " + randomRoll + " + " + attackModifier + " = " + (randomRoll+attackModifier) + ". The enemy armor class is: " + armorClass + " giving you a result of " + hitResult);
        return tempAttack;
    }
    public void printSword(){
        System.out.println("Your sword has damage: "+ damage);
    }
}
