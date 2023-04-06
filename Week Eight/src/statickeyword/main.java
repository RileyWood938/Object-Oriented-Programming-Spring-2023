package statickeyword;

public class main {
    static{System.out.println("static blocks allow code to execute before main");
    Painting.setArtist("Eric Aho");}
    public static void main(String[] args) { //The idea here is that an art gallery does shows of one artist at a time,
        // so keeping the artist the same across every painting is logical.

        Painting painting1 = new Painting(4,5,"Drift");
        Painting painting2 = new Painting(3,6,"inflection Point");

        System.out.println(painting1.toString());
        System.out.println(painting2.toString());

        //now change out all the paintings
        Painting.setArtist("Edward Hopper");
        painting1.setHeight(4.3f);
        painting1.setWidth(4.3f);
        painting2.setHeight(5.2f);
        painting2.setHeight(7f);
        painting1.setName("Nighthawks");
        painting1.setName("Universalist Church");

        System.out.println(painting1.toString());
        System.out.println(painting2.toString());

    }
}

/*
Static Variables
    They are common between all objects of the type.
    Used to save memory so only one instance of the variable needs to be saved
    Mutating a static variable changes it for all classes using it

Static Methods
    Static methods belong to the class rather than the instance
    Thus they can be used without an instance existing
    You have to use a static method to change a static variable
    Static methods can only use static variables
    Super() cannot be used with static

Static Block
    Static blocks are used to initialise a static variable
    they are called before the main method

Static Inner Class
    Static inner classes are inner classes that do not depend upon the outer class to be accessed.
    They are used much like static methods to access static data from the outer class.
*/
