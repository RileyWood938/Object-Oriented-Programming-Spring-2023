package entities;

import Items.Item;
import weapons.Weapon;
import weapons.exceptions.InventoryFullException;
import weapons.exceptions.ItemNotFoundException;

public class Inventory {
    private Item[] items;

    public Inventory(){
        items = new Item[10];
    }

    public Item[] getItems(){
        return items;
    }
    public Item getItemFromSlot(int slot){
        return items[slot];
    }
    public int getFullSlots(){
        int fullSlots = 0;
        for(Item i: items){
            if(i != null){
                fullSlots +=1;
            }
        }
        return fullSlots;
    }
    public void addItemToInventory(Item itemToAdd) throws InventoryFullException{
        int j = this.getFullSlots();
        if(this.getFullSlots() != items.length){
            items[j]=itemToAdd;
        }else{
            throw new InventoryFullException("inventory full when adding item: " + itemToAdd.toString());
        }
    }
    public void removeItemFromInventory(Item itemToRemove) throws ItemNotFoundException {
        boolean itemRemoved = false;
        for (Item i : items){
            if (i==itemToRemove){
                i=null;
                itemRemoved = true;
                break;
            }
        }
        if(! itemRemoved){
            throw  new ItemNotFoundException("Items.Item being removed was not found: " + itemToRemove.toString());
        }
    }

    public String toString(){
        String inventoryString = "";
        for (Item i: items){
            inventoryString = inventoryString + " Items.Item " + i + ": " + i.getName();
        }
        return ("Inventory: " + inventoryString + ".");
    }

    public boolean getWeaponFromSlot(int slot) {
        if(items[slot] instanceof Weapon){
            return true; //completely stuck here
        }else{
            return false;
        }
    }
}
