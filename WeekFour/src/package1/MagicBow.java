package package1;
import special.Ability;
import special.Attack;

/**
 * <p>Code for the Magic Bow class</p>
 * <p>stores a range, magic effect, and damage, and has methods to roll an attack against a given foe's armor class</p>
 */
public class MagicBow extends Bow{
    private Ability bowPower = new Ability();
    public MagicBow() {
        super();
        bowPower.pickRandomPower();
    }
    public MagicBow(int damage) {
        super(damage);
        bowPower.pickRandomPower();
    }
    public MagicBow(int damage, int range) {
        super(damage,range);
        bowPower.pickRandomPower();
    }
    public MagicBow(int damage, int range, int bowAbility) {
        super(damage,range);
        bowPower.setPowertype(bowAbility);
    }

    /**
     * <p>see Bow.rollAttack for info on functionality. Override to add magical effect</p>
     * @param distance takes distance from user to foe
     * @param armorClass takes armor class of the foe to compare with player's random roll
     * @param attackModifier takes the player's attack modifier
     * @return returns an attack
     */
    @Override
    public Attack rollAttack(int distance, int armorClass, int attackModifier) {
        Attack MagicAttack = super.rollAttack(distance, armorClass, attackModifier);
        MagicAttack.setEffect(bowPower.getAttackEffect());
        return MagicAttack;
    }

    @Override
    public void printBow(){
        System.out.println("Your Magic bow has damage: "+ damage + " and range: " + range + " and the effect: " + bowPower.getAttackEffect());
    }
}
