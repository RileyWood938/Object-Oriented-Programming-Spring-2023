package Items;

public class Item {
    private String name;
    public Item(String name){
        this.name = name;
    }
     public String getName(){
        return this.name;
     }
     public String toString(){
        return ("Items.Item: " + name);
     }
}
