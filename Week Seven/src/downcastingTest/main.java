package downcastingTest;

public class main {
    public static void main(String args[]){
        Item[] itemArray = new Item[2];
        itemArray[0] = new Item("apple");
        itemArray[1] = new SpecialItem("Orange", 2);
        System.out.println(itemArray[0].toString());
        System.out.println(SpecialItemThing((SpecialItem) itemArray[1]));
    }
    private static String SpecialItemThing(SpecialItem specialItem){
        return("this Item Is special! It has the Data: " + specialItem.SpecialItemThing());
    }
}
