package special;

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
