package package1;

import special.Attack;
import java.lang.Math;

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

    public void printBow(){
        System.out.println("Your Bow has damage: "+ damage + " and range: " + range);
    }
}
