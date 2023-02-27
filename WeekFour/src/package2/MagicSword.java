package package2;

import special.Ability;
import special.Attack;

public class MagicSword extends Sword {
    private Ability swordPower = new Ability();
    public MagicSword() {
        super();
        swordPower.pickRandomPower();
    }
    public MagicSword(int damage) {
        super(damage);
        swordPower.pickRandomPower();
    }
    public MagicSword(int damage, int bowAbility) {
        super(damage);
        swordPower.setPowertype(bowAbility);
    }

    /****
     * <p>see Sword.rollAttack for info on functionality. Override to add magical effect</p>
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an attack
     */
    @Override
    public Attack rollAttack(int armorClass, int attackModifier) {
        Attack MagicAttack = super.rollAttack(armorClass, attackModifier);
        MagicAttack.setEffect(swordPower.getAttackEffect());
        return MagicAttack;
    }
    @Override
    public void printSword(){
        System.out.println("Your Magic sword has damage: "+ damage  + " and the effect: " + swordPower.getAttackEffect());
    }
}

