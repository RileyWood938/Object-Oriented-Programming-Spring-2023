import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Math;
import java.util.Scanner;

public class ShapeFactoryController {
    public static void main(String[] args) {

        ShapeArrays shapesFromText;
        TextReader textReaderInstance = new TextReader();

        shapesFromText = textReaderInstance.CreateArraysFromTextFile("src\\input01.txt");

        float[] shapesMinusCircleAreaArray = areaArray(shapesFromText, shapesFromText.getCircleArray().length);

        for (float i: shapesMinusCircleAreaArray) {
            System.out.println(i);
        }
    }
    static float[] areaArray(ShapeArrays shapesFromText, int numberOfShapes){
        Shape[] shapesRetreivedFromClass = shapesFromText.getShapeArray();
        Shape[] circlesRetreivedFromClass = shapesFromText.getCircleArray();
        float[] temporaryAreaArray = new float[numberOfShapes];

        for (int i = 0; i < circlesRetreivedFromClass.length; i++) {
            temporaryAreaArray[i] = shapesRetreivedFromClass[i].getArea() - circlesRetreivedFromClass[i].getArea();
        }
        return temporaryAreaArray;
    }
}

class Shape{
    protected int numberOfSides = 0;
    protected float sideLength = 0f;
    float area = 0f;
    public Shape(int sides, float sideLength){
        numberOfSides = sides;
        sideLength = sideLength;
    }
    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    public void setSideLength(float sideLength) {
        this.sideLength = sideLength;
    }
    public float getArea() {
        return area;
    }
}
class Circle extends Shape{
    public Circle(int sides, float sideLength) {
        super(sides, sideLength);
        area = (float) (Math.PI*(sideLength*sideLength));
    }
}
class Triangle extends Shape{
    public Triangle(int sides, float sideLength) {
        super(sides, sideLength);
        area = (float) (((1f/4f)*(Math.sqrt(3d)))*(sideLength*sideLength));
    }
}
class Square extends Shape{
    public Square(int sides, float sideLength) {
        super(sides, sideLength);
        area = (float) (sideLength*sideLength);
    }
}
class Pentagon extends Shape{
    public Pentagon(int sides, float sideLength) {
        super(sides, sideLength);
        area = (float) ((sideLength*sideLength)*(1f/4f)*Math.sqrt(5*(5+(2*(Math.sqrt(5))))));
    }
}

class TextReader {
    public ShapeArrays CreateArraysFromTextFile(String pathName) {

        File inputFile = new File(pathName);
        Scanner scanner = null;

        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int numberOfLines = getNumberOfLinesFromFirstline(scanner);
        Shape[] shapesArray = new Shape[numberOfLines];
        Shape[] circlesArray = new Shape[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            Line currentLine = new Line(scanner.nextLine());
            shapesArray[i] = currentLine.createShapeFromLine();
            circlesArray[i] = currentLine.createCircleFromLine();
        }
        scanner.close();

        ShapeArrays  outputArrays = new ShapeArrays(shapesArray, circlesArray);
        return(outputArrays);
    }

    private int getNumberOfLinesFromFirstline(Scanner scanner){
        try{
            String firstLineData = scanner.nextLine();
            return(Integer.parseInt(firstLineData.strip()));
        }catch(Exception e){
            System.out.println("error parsing line 1, no integer or non-integer detected");
            return(0);
        }
    }
}
class ShapeArrays{
    private Shape[] shapeArray;
    private Shape[] circleArray;
    public ShapeArrays(Shape[] shapeArray, Shape[] circleArray){
        this.shapeArray = shapeArray;
        this.circleArray = circleArray;
    }
    public Shape[] getShapeArray() {
        return shapeArray;
    }
    public Shape[] getCircleArray() {
        return circleArray;
    }
}
class Line{
    private String inputline = null;
    private float[] numbersFromInputArray = new float[3];
    public Line(String inputline){
        this.inputline = inputline;

        String[] inputLineCharactersArray = inputline.split(",", 3);

        for (int j = 0; j < inputLineCharactersArray.length; j++) {
            inputLineCharactersArray[j] = inputLineCharactersArray[j].strip();
            this.numbersFromInputArray[j] = Float.parseFloat(inputLineCharactersArray[j]);
        }
    }
    public Shape createShapeFromLine(){
        int numberOfSides =  Math.round(numbersFromInputArray[0]);
        Shape createdShape;

        if(numberOfSides >4){
            createdShape = new Pentagon( numberOfSides , numbersFromInputArray[1]);
        }else if(numberOfSides >3){
            createdShape = new Square( numberOfSides , numbersFromInputArray[1]);
        }else if(numberOfSides >2) {
            createdShape = new Triangle( numberOfSides , numbersFromInputArray[1]);
        }else{
            createdShape = new Circle( numberOfSides , numbersFromInputArray[1]);
        }

        return createdShape;
    }

    public Circle createCircleFromLine(){
        Circle createdCircle = new Circle(1, numbersFromInputArray[2]);
        return createdCircle;
    }
}


