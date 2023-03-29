package weapons;

import Items.Item;
import weapons.exceptions.negativeInputException;

public class Weapon extends Item {
    private int damage;
    private String name;
    private int range;

    public Weapon(String name, int inputDamage) throws negativeInputException {
        super(name);
        this.range = 1;
        if(inputDamage>=0) {
            this.damage = inputDamage;
        }else{
            throw new negativeInputException("negative input in Weapon constructor: " + inputDamage);
        }
    }

    public Attack rollAttack(int armorClass, int attackModifier, int distance){
        Attack tempAttack = new Attack(attackModifier, armorClass, this.damage, distance, 1);
        return tempAttack;
    }
    public Attack rollAttack(int armorClass, int attackModifier, int distance, String effect){
        Attack tempAttack = new Attack(attackModifier, armorClass, this.damage, distance, 1, effect);
        return tempAttack;
    }
    public Attack rollAttack(int armorClass, int attackModifier, int distance, int range){
        Attack tempAttack = new Attack(attackModifier, armorClass, this.damage, distance, range);
        return tempAttack;
    }
    public Attack rollAttack(int armorClass, int attackModifier, int distance, int range, String effect){
        Attack tempAttack = new Attack(attackModifier, armorClass, this.damage, distance, range, effect);
        return tempAttack;
    }

    public void setDamage(int inputDamage) throws negativeInputException {
        if(inputDamage>0){
            this.damage = inputDamage;
        }else{
            throw new negativeInputException("negative number input as damage: " + inputDamage);
        }
    }

    public int getDamage(){
        return this.damage;
    }

    public String getEffect(){
        return "no effect";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
