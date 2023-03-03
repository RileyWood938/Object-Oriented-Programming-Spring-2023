package weapons.swords;

import weapons.Ability;
import weapons.Attack;

public class MagicSword extends Sword {
    private Ability swordEffect = new Ability();
    public MagicSword() {
        super();
        swordEffect.pickRandomPower();
    }
    public MagicSword(String SwordAbility) {
        super();
        swordEffect.setPowertype(SwordAbility);
    }
    public MagicSword(int damage) {
        super(damage);
        swordEffect.pickRandomPower();
    }
    public MagicSword(int damage, String SwordAbility) {
        super(damage);
        swordEffect.setPowertype(SwordAbility);
    }

    /****
     * <p>see Weapons.Sword.rollAttack for info on functionality. Override to add magical effect</p>
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an attack
     */
    @Override
    public Attack rollAttack(int armorClass, int attackModifier) {
        Attack MagicAttack = super.rollAttack(armorClass, attackModifier);
        MagicAttack.setEffect(swordEffect.getAttackEffect());
        return MagicAttack;
    }
    @Override
    public String printSword(){
        return("Your Magic sword has damage: "+ this.getDamage()  + " and the effect: " + swordEffect.getAttackEffect());
    }

    public String getSwordEffect(){
        return swordEffect.getAttackEffect();
    }
}

