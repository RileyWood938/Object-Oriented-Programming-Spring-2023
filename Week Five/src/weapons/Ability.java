package weapons;

/**
 * <p>class to store the magical abilities weapons can gain</p>
 * <p>presently stores ability as an integer which is processed into an effect from fire, ice, and none</p>
 * <p>class exists so that future functionality (effect descriptions, more complex effects) could be easily added</p>
 */
public class Ability {
    private String[] powers = {"no effect", "fire", "ice"};
    private String powerType;
    public Ability(){
        powerType = "no effect";
    }
    public void pickRandomPower(){
        int randomNumber =  (int) Math.ceil(Math.random() * 2);
        powerType = powers[randomNumber];

    }

    public void setPowertype(String inputAbility) {
        powerType = inputAbility;
    }

    /**
     * <p>method to turn the powertype integer into a string and return that</p>
     * @return returns the effect of the weapon as a string
     */
    public String getAttackEffect(){
        return powerType;
    }
}
