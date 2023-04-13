package question2;

public class testDrive {
    public static void main(String[] args){
        SeiveOfEratosthenes testSeive = new SeiveOfEratosthenes();
        testSeive.extendTheLimit(5);
        testSeive.saveToFile();
        testSeive.extendTheLimit(20);
        testSeive.saveToFile();
        testSeive.extendTheLimit(100);
        testSeive.saveToFile();
    }
}
