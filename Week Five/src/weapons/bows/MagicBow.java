package weapons.bows;

import weapons.Ability;
import weapons.Attack;
import weapons.exceptions.negativeInputException;

public class MagicBow extends Bow{
    private Ability bowPower = new Ability();
    public MagicBow(String name) throws negativeInputException{
        super(name);
        bowPower.setPowertype("fire");
    }
    public MagicBow(String name, int damage)throws negativeInputException {
        super(name, damage);
        bowPower.setPowertype("fire");
    }
    public MagicBow(String name, int damage, int range) throws negativeInputException {
        super(name, damage,range);
        bowPower.setPowertype("fire");
    }
    public MagicBow(String name, int damage, int range, String bowAbility) throws negativeInputException{
        super(name, damage,range);
        bowPower.setPowertype(bowAbility);
    }

    @Override
    public Attack rollAttack(int distance, int armorClass, int attackModifier) {
        return super.rollAttack(attackModifier, armorClass, distance, this.getRange(), bowPower.getAttackEffect());
    }

    @Override
    public String printBow(){
        return (super.printBow() + " and the effect: " + bowPower.getAttackEffect());
    }
}
