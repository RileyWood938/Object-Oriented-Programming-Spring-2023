import entities.Character;
import entities.Combatant;
import entities.Location;
import weapons.Weapon;
import weapons.exceptions.InventoryFullException;
import weapons.exceptions.negativeInputException;
import weapons.swords.MagicSword;
import weapons.swords.Sword;
import weapons.bows.Bow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);

        System.out.println("Name your Character: ");

        String guyName = mainScanner.next();

        Combatant MainCharacter = new Combatant( guyName,  new Location(0,0), 15);
        Combatant Enemy1 = new Combatant( "Awakened Gargoyle",  new Location(1,1), 16);

        System.out.println(MainCharacter.toString());

        System.out.println("Choose your weapon: \n [a] for longsword \n [b] for crossbow \n [c] for flaming sword of doom ");

        String result = mainScanner.next();

        if(result == "c"){
            try {
                MainCharacter.getInventory().addItemToInventory(new MagicSword("flaming sword of doom", 15, "fire"));
            } catch (InventoryFullException e) {
                throw new RuntimeException(e);
            } catch (negativeInputException e) {
                throw new RuntimeException(e);
            }
        }else if(result == "b"){
            try {
                MainCharacter.getInventory().addItemToInventory(new Bow("crossbow", 8, 45));
            } catch (InventoryFullException e) {
                throw new RuntimeException(e);
            } catch (negativeInputException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                MainCharacter.getInventory().addItemToInventory(new Sword("longsword", 5));
            } catch (InventoryFullException e) {
                throw new RuntimeException(e);
            } catch (negativeInputException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("A gargoyle slowly rises to life");

        System.out.println("Attack it?\n [a] for yes");

        if(mainScanner.next() == "a"){
            System.out.println("select an inventory Slot to attack with (type the number of the slot)");
            System.out.println(MainCharacter.getInventory().toString());

            int slotToAttackFrom = mainScanner.nextInt();


                if(MainCharacter.getInventory().getWeaponFromSlot(slotToAttackFrom)){
                    MainCharacter.attack(Enemy1, (Weapon) MainCharacter.getInventory().getWeaponFromSlot(slotToAttackFrom));

                }

        }




    }
}