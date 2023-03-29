package weapons.bows;

import weapons.Attack;
import weapons.Weapon;
import weapons.exceptions.negativeInputException;

public class Bow extends Weapon {
    private int range;

    public Bow(String name) throws negativeInputException {
        super(name,5);
        this.range = 30;
    }
    public Bow(String name, int damage) throws negativeInputException {
        super(name, damage);
        this.range = 30;
    }
    public Bow(String name, int damage, int range) throws negativeInputException {
        super(name, damage);
        if (range >= 0) {
            this.range = range;
        }else{
            throw new negativeInputException("negative range in Bow constructor:"+ range);
        }
    }

    public Attack rollAttack(int armorClass, int attackModifier, int distance){
        return super.rollAttack(attackModifier, armorClass, distance, range);
    }
    public Attack rollAttack(int armorClass, int attackModifier, int distance, String effect){
        return super.rollAttack(attackModifier, armorClass, distance, range, effect);
    }

    public String printBow()
    {
        return("Your Bow has damage: "+ super.getDamage() + " and range: " + range);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
