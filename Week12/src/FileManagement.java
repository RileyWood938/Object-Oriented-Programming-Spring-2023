import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Riley Wood
 * @version April 29th, 2023
 * This class manages the accessing and saving of data to files in the testing step. Saving the Graph is handled by the
 * GraphPrinter
 */
public class FileManagement {

    /**
     * This method runs the tests and saves their data to file.
     * @param numbersToCheck takes an array of integers which determine how many numbers will be in the set sorted by
     *                       each test
     * @param sortingMethodsToCheck determines what sorting methods will be tested
     * @param filePath determines where the resulting data will end up
     */
    public static void writeTestDataToFile(int[] numbersToCheck, String[] sortingMethodsToCheck, String filePath) {
        RuntimeTests myRecorder = new RuntimeTests();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (int i: numbersToCheck) {
                writer.write(myRecorder.getEmpiricalRunningTime(i, sortingMethodsToCheck));
            }
            writer.close();
        } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**This method fetches the testing data from a specified file.
     * @param file the file storign the data
     * @return returns a matrix of doubles where the rows represent each tested type of sorting algorithm and the
     * columns represent each test benchmark
     * @throws FileNotFoundException throws an error if a bad filepath is specified
     */
    public static double[][] getTestDataFromFile(String file) throws FileNotFoundException {

        Scanner fileReader = new Scanner(new File(file));
        ArrayList<double[]> fileData = new ArrayList<double[]>();

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if (!line.isEmpty()) {
                String[] currentLine = line.split(",");
                double[] currentData = new double[currentLine.length];

                for (int i = 0; i < currentLine.length; i++) {
                    System.out.println(currentLine[i]);
                    currentData[i] = Double.parseDouble(currentLine[i]);
                }

                fileData.add(currentData);
            }
        }
        fileReader.close();

        double[][] result = new double[fileData.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = fileData.get(i);
        }
        result = transposeData(result);

        return result;
    }

    /**This method takes a matrix of doubles and transposes them. It is used to switch the rows and columns of the
     * input matrix as the specifications for saving the data differ from graphing said data.
     * @param input a matrix of doubles to be transposed
     * @return the transposed matrix
     */
    private static double[][] transposeData(double[][] input) {
        double[][] output = new double[input[0].length][input.length];
        for(int i=0; i<input[0].length; i++){
            for (int j = 0; j < input.length; j++) {
                output[i][j] = input[j][i];
            }
        }
        return output;
    }
}
