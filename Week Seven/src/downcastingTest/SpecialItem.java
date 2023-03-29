package downcastingTest;

public class SpecialItem extends Item {

    private int data2;
    public SpecialItem(String data, int data2){
        super(data);
        this.data2 = data2;
    }
    public String SpecialItemThing(){
        return(super.toString() + " and " + this.data2);
    }
}
