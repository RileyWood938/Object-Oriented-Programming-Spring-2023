package mainPackage;

import package1.BowTestCode;

public class Main {
    public static void main(String[] args) {
        BowTestCode bowTester = new BowTestCode();
        bowTester.testBow();
    }

    public static String OverloadableFunction(){
        return("nothing");
    }

    public static String OverloadableFunction(String input){
        return (input);
    }

    public static String OverloadableFunction (String input1, String input2){
        return (input1 + input2);
    }
}

class SimpleClass{
    String identity;
    String description;
    public SimpleClass(String inputIdentity){
        this.identity = inputIdentity;
    }

    public SimpleClass(String inputIdentity, String inputDescription){
        this.identity = inputIdentity;
        this.description = inputDescription;
    }
}