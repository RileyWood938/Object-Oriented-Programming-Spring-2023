package weapons;

/**
 * <p>class to store an individual attack</p>
 * <p>stores attack damage, result (hit or miss) and any magical effect</p>
 * <p>used as a return type by the various weapons' attack methods</p>
 */
public class Attack {
    private int randomRoll;
    private int attackModifier;
    private int armorClass;
    private int damage;
    private int distance;
    private int range;
    private String hitResult;
    private String effect;
    public Attack(int attackModifier, int armorClass, int weaponDamage, int distance, int range ){
        this.randomRoll = (int) Math.ceil(Math.random() * 20);
        this.attackModifier = attackModifier;
        this.armorClass = armorClass;
        this.damage = weaponDamage;
        this.distance = distance;
        this.range = range;
        this.effect = "no effect";
        if(range>=distance){
            if(randomRoll + attackModifier >= armorClass){
                hitResult = "Hit";
            }else {
                hitResult = "Miss";
            }
        }else{
            hitResult = "Miss";
        }
    }
    public Attack(int attackModifier, int armorClass, int weaponDamage, int distance, int range, String effect){
        this.randomRoll = (int) Math.ceil(Math.random() * 20);
        this.attackModifier = attackModifier;
        this.armorClass = armorClass;
        this.damage = weaponDamage;
        this.distance = distance;
        this.range = range;
        this.effect = effect;
        if(range>=distance){
            if(randomRoll + attackModifier >= armorClass){
                hitResult = "Hit";
            }else {
                hitResult = "Miss";
            }
        }else{
            hitResult = "Miss";
        }
    }
    public int getDamage(){
        if(hitResult != "Miss"){
            return damage;
        }
        return 0;
    }
    public String getHitResult() {
        return hitResult;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(String newEffect){
        this.effect = newEffect;
    }

    public String printAttack(){
        return("you rolled a " + randomRoll + " + " + attackModifier + " = " + (randomRoll+attackModifier) + ". " +
                "The enemy armor class is: " + armorClass + " giving you a result of " + hitResult + " for " + this.getDamage() +
                " damage, and " + effect + ".");
    }
}
