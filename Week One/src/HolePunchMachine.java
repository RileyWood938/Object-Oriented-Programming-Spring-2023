import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HolePunchMachine {
    public static void main (String[] args){
        TextReader textReaderInstance = new TextReader();
        textReaderInstance.readTextFile("src\\scratch.txt");
    }
}
class MetalSheet{
    private float sideLength;
    private float holeDiameter;
    public MetalSheet(float sideLength, float holeDiameter){
        this.sideLength = sideLength;
        this.holeDiameter = holeDiameter;
    }
    private float sheetDiagonal(float SideLength){
        return (float) (SideLength * Math.sqrt(2));
    }
    private float radius(float holeDiameter){
        return(holeDiameter/2);
    }
    private float distanceFromCornerToCircleEdge(float sheetDiagonal, float radius){
        return((sheetDiagonal/2)-radius);
    }
    void printOutput(){
        float numberToPrint = distanceFromCornerToCircleEdge(sheetDiagonal(sideLength), radius(holeDiameter));
        System.out.println(numberToPrint);
    }

}

class TextReader {
    public void readTextFile(String pathName) {
        MetalSheet[] metalSheetsArray = new MetalSheet[0];
        Scanner scanner = null;

        try {
            File inputFile = new File(pathName);
            scanner = new Scanner(inputFile);

            int numberOfLines = 0;

            numberOfLines = numberOfLinesExtractedFromText(scanner);

            metalSheetsArray = new MetalSheet[numberOfLines];

            readThroughLinesAndCreateMetalSheetArray(scanner, numberOfLines, metalSheetsArray);

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found");
        }

        for (MetalSheet i : metalSheetsArray) {
            i.printOutput();
        }
    }
    void readThroughLinesAndCreateMetalSheetArray(Scanner textReader, int numberOfLines, MetalSheet[] metalSheetsArray){
        for (int i = 0; i < numberOfLines; i++) {
            String currentLineData;
            currentLineData = textReader.nextLine();
            parseCurrentLine(currentLineData, metalSheetsArray, i);
        }
    }
    static void parseCurrentLine(String inputLine, MetalSheet[] metalSheetsArray, int currentLoopIteration){
        float sideLength = 0;
        float holeDiameter = 0;

        String[] inputLineCharactersArray = inputLine.split( ",", 0);

        for(int i=0; i<inputLineCharactersArray.length; i++) {
            inputLineCharactersArray[i] =inputLineCharactersArray[i].strip();
        }

        try {

            sideLength = Float.parseFloat(inputLineCharactersArray[0].strip());
            holeDiameter = Float.parseFloat(inputLineCharactersArray[1].strip());

        } catch (NumberFormatException e) { //if the first line does not only contain a float, print an error
            System.out.print("error in line '");
            System.out.print(inputLine); //make sure to print the problem line as well
            System.out.println("'");
        }

        metalSheetsArray[currentLoopIteration] = new MetalSheet(sideLength,holeDiameter);
    }
    int numberOfLinesExtractedFromText(Scanner scanner){
        String currentLineData = "";

        if (scanner.hasNextLine()) {
            currentLineData = scanner.nextLine();
            try {
                return (Integer.parseInt(currentLineData.strip()));

            } catch (NumberFormatException e) { //if the first line does not only contain an integer, return 0

                System.out.print("error in line 1, no number detected in '");
                System.out.print(currentLineData);
                System.out.println("'");
                return (0);

            }
        }
        return(0);

    }
}
