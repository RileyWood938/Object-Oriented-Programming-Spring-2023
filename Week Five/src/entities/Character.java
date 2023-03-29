package entities;

public class Character {
    private Location location;
    private Inventory inventory;
    private String name;
    public Character(String name){
        this.name = name;
        this.location = new Location();
        this.inventory = new Inventory();
    }
    public Character(String name, Location location){
        this.name = name;
        this.location = location;
        this.inventory = new Inventory();
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
