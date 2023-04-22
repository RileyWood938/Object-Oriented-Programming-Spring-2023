package question2;

public class testDrive {
    public static void main(String[] args){
        SeiveOfEratosthenes2 testSeive = new SeiveOfEratosthenes2(4);
        testSeive.extendTheLimit(5);
        testSeive.printAll();
        testSeive.extendTheLimit(20);
        testSeive.printAll();
        testSeive.extendTheLimit(100);
        testSeive.printAll();
    }
}
