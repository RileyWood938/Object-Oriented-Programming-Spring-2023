package question2;

import java.util.ArrayList;

public class SeiveOfEratosthenes2 implements PrimeNumberGenerator {
    static private ArrayList<Integer> primes;
    static private boolean[] primesAsBools;
    private int maxLimit;

    public SeiveOfEratosthenes2(int maxLimit){
        this.maxLimit = maxLimit;
        generatePrimeUpToMaxLimit();
    }
    public void printAll(){
        System.out.println(primes);
    }
    public void extendTheLimit(int newLimit){
        this.maxLimit = newLimit;
        generatePrimeUpToMaxLimit();
    }
    public ArrayList<Integer> getPrimesUpToValue(int upperPrimeLimit) {
        if (upperPrimeLimit > maxLimit) {
            extendTheLimit(upperPrimeLimit);
        }
        ArrayList<Integer> returnArray = new ArrayList<>(upperPrimeLimit);
        for (int i = 0; i <= upperPrimeLimit; i++)
            returnArray.add(primes.get(i));
        return (returnArray);
    }
    @Override
    public void generatePrimeUpToMaxLimit() {
        primesAsBools = new boolean[maxLimit];
        primes = convertToNumbersFromBools(generatePrimeBooleanArray(primesAsBools));
    }

    private ArrayList<Integer> convertToNumbersFromBools(boolean[] intakeBooleans) {
        ArrayList<Integer> outputArray = new ArrayList<Integer>();
        for (int i = 2; i < intakeBooleans.length; i++) {
            if (intakeBooleans[i] == false){
                outputArray.add(i);
            }
        }
        return outputArray;
    }

    private boolean[] generatePrimeBooleanArray(boolean[] intakeArray){
        for(int i=2; i< intakeArray.length; i++){
            if(intakeArray[i] == false){
                int j=i;
                while(j<intakeArray.length-i){
                    j+=i;
                    intakeArray[j] = true;
                }
            }
        }
        return intakeArray;
    }
}
