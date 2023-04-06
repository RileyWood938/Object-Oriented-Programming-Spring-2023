package innerclass;

public class OuterClass {
        public int x = 10;

        class InnerClass {
            int y = 5;
            public int innerClassAddition(){
                return x+y;
            }
        }

    static class InnerClass2 {
        static int y = 5;
    }

}
