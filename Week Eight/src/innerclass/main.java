package innerclass;

public class main {
    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();

        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.y + myOuter.x);
        myOuter.x = 6;
        System.out.println(myInner.innerClassAddition());

        System.out.println(OuterClass.InnerClass2.y);
    }
}
