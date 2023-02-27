package special;

/**
 * <p>class to store an individual attack</p>
 * <p>stores attack damage, result (hit or miss) and any magical effect</p>
 * <p>used as a return type by the various weapons' attack methods</p>
 */
public class Attack {
    int damage;
    String hitResult;
    String effect;
    public Attack(int weaponDamage, String hitResult){
        this.hitResult = hitResult;
        this.damage = weaponDamage;
        this.effect = "no effect";
    }
    public Attack(int weaponDamage, String hitResult, String effect){
        this.hitResult = hitResult;
        this.damage = weaponDamage;
        this.effect = effect;
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
        return("your attack was a " + hitResult + " for " + getDamage() + " damage and " + effect);
    }
}
