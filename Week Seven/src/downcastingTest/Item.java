package downcastingTest;

import java.security.PublicKey;

public class Item {
    private String data;
    public Item(String data){
        this.data = data;
    }
    public String toString(){
        return("this Item has The Data: " + data);
    }
}
