package entities;
import java.lang.Math;
import weapons.Weapon;

public class Combatant extends Character{
    private int armorClass;
    private int initiative;
    private int attackModifier;
    public Combatant(String name, Location location, int armorClass) {
        super(name, location);
        this.armorClass = armorClass;
    }
    public Combatant(String name, Location location, int armorClass, int initiative) {
        super(name, location);
        this.armorClass = armorClass;
        this.initiative = initiative;
    }

    public int getInitiative(){
        return initiative;
    }
    public int getArmorClass() {
        return armorClass;
    }
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public void attack(Combatant enemy, Weapon weapon){
        Location thisLocation = this.getLocation();
        Location enemyLocation = enemy.getLocation();
        int distanceFromThisToEnemy = calculateDistanceBetweenPoints(thisLocation.getXcoordinate(), thisLocation.getYcoordinate(), enemyLocation.getXcoordinate(), enemyLocation.getYcoordinate());
        weapon.rollAttack(enemy.getArmorClass(), attackModifier, distanceFromThisToEnemy, weapon.getRange());
    }

    public int calculateDistanceBetweenPoints(int pointOneX, int pointOneY, int pointTwoX, int pointTwoY){
        int XDifference = pointOneX - pointTwoX;
        int YDifference = pointOneY - pointTwoY;
        double Square = Math.pow(XDifference, 2) + Math.pow(YDifference, 2);
        return (int) Math.sqrt(Square);
    }
}
