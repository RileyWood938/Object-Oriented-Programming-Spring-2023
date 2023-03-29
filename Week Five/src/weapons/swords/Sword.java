package weapons.swords;

import weapons.Attack;
import weapons.Weapon;
import weapons.exceptions.negativeInputException;

public class Sword extends Weapon {
    public Sword(String name) throws negativeInputException {
        super(name,5);
    }
    public Sword(String name, int damage) throws negativeInputException {
        super(name, damage);
    }

    @Override
    public Attack rollAttack(int armorClass, int attackModifier, int distance){
        return (super.rollAttack(armorClass, attackModifier, distance));
    }
    @Override
    public Attack rollAttack(int armorClass, int attackModifier, int distance, String effect){
        return (super.rollAttack(armorClass, attackModifier, distance, effect));
    }
    public String printSword(){
        return ("Your sword has damage: "+ super.getDamage());
    }

}
