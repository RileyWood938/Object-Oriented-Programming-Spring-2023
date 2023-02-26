package package1;
import special.Ability;
import special.Attack;

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
    @Override
    public Attack rollAttack(int distance, int armorClass, int attackModifier) {
        Attack MagicAttack = super.rollAttack(distance, armorClass, attackModifier);
        MagicAttack.setEffect(bowPower.getAttackEffect());
        return MagicAttack;
    }
}
