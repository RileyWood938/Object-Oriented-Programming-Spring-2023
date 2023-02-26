package special;

public class Ability {
    int powertype;
    public Ability(){
        powertype = 0;
    }
    public void pickRandomPower(){
        powertype = 1;
    }

    public void setPowertype(int bowAbility) {
        powertype = bowAbility;
    }

    public String getAttackEffect(){
        if (powertype ==1){
            return "fire";
        }else if(powertype == 2){
            return "ice";
        }
        return "none";
    }
}
