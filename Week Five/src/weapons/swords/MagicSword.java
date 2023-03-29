package weapons.swords;

import weapons.Ability;
import weapons.Attack;
import weapons.exceptions.negativeInputException;

public class MagicSword extends Sword {
    private Ability swordEffect = new Ability();
    public MagicSword(String name, String SwordAbility) throws negativeInputException {
        super(name);
        swordEffect.setPowertype(SwordAbility);
    }
    public MagicSword(String name, int damage) throws negativeInputException {
        super(name, damage);
        swordEffect.pickRandomPower();
    }
    public MagicSword(String name, int damage, String SwordAbility) throws negativeInputException {
        super(name, damage);
        swordEffect.setPowertype(SwordAbility);
    }

    /****
     * <p>see Weapons.Sword.rollAttack for info on functionality. Override to add magical effect</p>
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an attack
     */
    @Override
    public Attack rollAttack(int armorClass, int attackModifier, int distance) {
        return super.rollAttack(armorClass, attackModifier, distance, swordEffect.getAttackEffect());
    }
    @Override
    public String printSword(){
        return(super.printSword() + " and the effect: " + swordEffect.getAttackEffect());
    }

    public String getSwordEffect(){
        return swordEffect.getAttackEffect();
    }
}

