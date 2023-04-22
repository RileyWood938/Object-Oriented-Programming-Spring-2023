package question2;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class SeiveOfEratosthenes implements PrimeNumberGenerator {
    private int[] primes;
    private int maxLimit;

    @Override
    public void generatePrimeUpToMaxLimit() {
        ArrayList<Integer> allNumbers = new ArrayList<Integer>(maxLimit);
        for (int i = 2; i <= maxLimit; i++) {
            allNumbers.add(i);
        }

        ArrayList<Integer> primesList = getPrimes(allNumbers);
        int[] tempArray = new int[primesList.size()];
        for(int i = 0; i < primesList.size(); i++) {
            if (primesList.get(i) != null) {
                tempArray[i] = primesList.get(i);
            }
        }
        this.primes = tempArray;

    }

    public int[] getPrimes(int upperPrimeLimit) {
        if (upperPrimeLimit >= 0) {
            if (upperPrimeLimit > maxLimit) {
                extendTheLimit(upperPrimeLimit);
            }

            int[] returnArray = new int[upperPrimeLimit];
            for (int i = 0; i <= upperPrimeLimit; i++)
                returnArray[i] = primes[i];
            return (returnArray);

        } else {
            return null;
        }
    }

    public void extendTheLimit(int newLimit) {
        if(newLimit >0) {
            this.maxLimit = newLimit;
            generatePrimeUpToMaxLimit();
        }
    }

    public void printAll() {
        if(maxLimit>0) {
            System.out.println(primes);
        }
    }

    public void saveToFile(){
       try {
            StringBuilder numbersToWrite = new StringBuilder("#" + maxLimit + "\n");
            for(int i: primes)
                if(i==2)
                    numbersToWrite.append(i);
                else
                    numbersToWrite.append(", "+i);
           BufferedWriter writer = new BufferedWriter(new FileWriter(maxLimit+".csv"));
           writer.write(numbersToWrite.toString());

            writer.close();
        }catch (IOException e){
           throw new RuntimeException(e);
       }
    }

    private ArrayList<Integer> getPrimes(ArrayList<Integer> inputArray, ArrayList<Integer> primesSoFar) {
        if (inputArray.size() == 1) {
            primesSoFar.add(inputArray.get(0));
            return primesSoFar;
        }
        if (inputArray.size() < 1)
            return primesSoFar;

        int currentPrime = inputArray.get(0);
        primesSoFar.add(currentPrime);

        Iterator<Integer> iterator = inputArray.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i%currentPrime ==0)
                iterator.remove();
        }
//        for (int i = 0; i < inputArray.size(); i++) {
//            if (inputArray.get(i) % currentPrime != 0) {
//                inputArray.remove(i);
//            }
//        }
        getPrimes(inputArray, primesSoFar);
        return primesSoFar;
    }

    private ArrayList<Integer> getPrimes(ArrayList<Integer> inputArray) {
        ArrayList<Integer> primesSoFar = new ArrayList<Integer>();
        if (inputArray.size() == 1) {
            primesSoFar.add(inputArray.get(0));
            return primesSoFar;
        }
        if (inputArray.size() < 1)
            return primesSoFar;
        int currentPrime = inputArray.get(0);
        primesSoFar.add(currentPrime);
        Iterator<Integer> iterator = inputArray.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i%currentPrime ==0)
                iterator.remove();
        }
//        for (int i = 0; i < inputArray.size(); i++) {
//            if (inputArray.get(i) % currentPrime == 0) {
//                inputArray.remove(i);
//            }
//        }
        getPrimes(inputArray, primesSoFar);
        return primesSoFar;
    }
}
