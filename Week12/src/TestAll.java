import java.io.IOException;

/**
 * @author Riley Wood
 * @version April 29th, 2023
 * This file tests the functionality off all parts of the program
 */
public class TestAll {
    /**
     * The testAll method tests all functionality. It tests 4 sorting methods, saves their data in the specified format
     * to a file. It then uses that data to create a chart, displays it, and saves it to file as well.
     */
    public static void testAll(){

        //create an array of all testing values we want to use
        int[] numbersToCheck = {5,10,50,100,200,500,1000,5000,10000};
        //create an array of all sorting methods we want to test
        String[] sortingMethodsToCheck = {"insertionSort", "selectionSort", "mergeSort", "bubbleSort"};

        //run the tests and save their data to a file
        FileManagement.writeTestDataToFile(numbersToCheck, sortingMethodsToCheck, "src/assignment02RunningTimeWood.csv");

        //Create a new GraphPrinter object and use it to create the graph given the generated data
        GraphPrinter myPrinter = new GraphPrinter();
        try {
            myPrinter.createMultiSeriesGraph(sortingMethodsToCheck, convertToDoubles(numbersToCheck), FileManagement.getTestDataFromFile("src/assignment02RunningTimeWood.csv") );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    /**
     * This method converts an array of integers into an array of doubles. It is used because integers are required to
     * run the tests, but xChart requires an array of doubles, so they are converted before being sent to the graphing
     * class in order to allow that class to also take doubles
     * @param ints the array of integers to be converted
     * @return the array of doubles equal to the integer input
     */
    private static double[] convertToDoubles(int[] ints) {
        double[] graphXData = new double[ints.length];

        for (int i = 0; i< ints.length; i++) {
            graphXData[i] = ints[i];
        }
        return graphXData;
    }
}
