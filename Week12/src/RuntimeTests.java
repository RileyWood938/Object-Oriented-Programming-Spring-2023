import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Riley Wood
 * @version April 29th, 2023
 * This file Graphs Data using the xChart library
 */
public class RuntimeTests {

    /**This method tests a list of sorting methods on an array of n random integers.
     * @param n the number of integers to be sorted by each algorithm
     * @param methodsToCheck the methods which should be checked (note: the strings must *exactly* match the method
     *                       names
     * @return returns a string containing the time in seconds it took each method to execute with 15 decimal places of
     * precision. Each time is separated by a comma
     * @throws InvocationTargetException
     * @throws NoSuchMethodException this error occurs when an invalid method name is invoked. Check the
     *      * methodsToCheck input and ensure everything is correctly spelled
     * @throws IllegalAccessException
     */
    public String getEmpiricalRunningTime(int n, String[] methodsToCheck) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        if (n < 1)
            return null;
        Integer[] numbersToTest = RandomIntegerGenerator.generateRandomNumbers(n);
        double[] sortingTimes = new double[methodsToCheck.length];
        for (int i = 0; i < methodsToCheck.length; i++) {
            sortingTimes[i] = testSortingMethod(methodsToCheck[i], numbersToTest);
        }

        return (String.format("%.15f", sortingTimes[0]) + ',' + String.format("%.15f", sortingTimes[1]) + ',' + String.format("%.15f", sortingTimes[2]) + ',' + String.format("%.15f", sortingTimes[3]) + "\n");

    }


    /** This method tests how long it takes to run a given sorting algorithm. It generates a list of n random integers
     * via RandomIntegerGenerator.generateRandomNumbers() then records how long it takes said method to run
     * @param methodName the name of the method to be tested (as a string)
     * @param n the number of random integers to test
     * @return returns a double representing how long it took the method to execute
     * @throws NoSuchMethodException this error occurs when an invalid method name is invoked. Check the
     *             methodsToCheck input and ensure everything is correctly spelled
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private double testSortingMethod(String methodName, Integer[] numbers) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Integer[] temp = new Integer[numbers.length];
        System.arraycopy(numbers, 0, temp, 0, numbers.length);

        Method sortingAlgorithm = SortingAlgorithms.class.getMethod(methodName, Comparable[].class);

        long startTime = System.nanoTime();

        sortingAlgorithm.invoke(null, (Object) temp);

        long stopTime = System.nanoTime();

        return (double) (stopTime - startTime) / 1000000000;
    }
}
