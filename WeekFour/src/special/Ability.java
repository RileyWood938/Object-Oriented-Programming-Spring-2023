package special;

/**
 * <p>class to store the magical abilities weapons can gain</p>
 * <p>presently stores ability as an integer which is processed into an effect from fire, ice, and none</p>
 * <p>class exists so that future functionality (effect descriptions, more complex effects) could be easily added</p>
 */
public class Ability {
    int powertype;
    public Ability(){
        powertype = 0;
    }
    public void pickRandomPower(){
        powertype = (int) Math.ceil(Math.random() * 2);
    }

    public void setPowertype(int bowAbility) {
        powertype = bowAbility;
    }

    /**
     * <p>method to turn the powertype integer into a string and return that</p>
     * @return returns the effect of the weapon as a string
     */
    public String getAttackEffect(){
        if (powertype ==1){
            return "fire";
        }else if(powertype == 2){
            return "ice";
        }
        return "no effect";
    }
}
