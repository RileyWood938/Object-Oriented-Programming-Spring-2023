package battleship;

import java.lang.Math;
public class Battleship {
    public static void main(String[] args) {

    }
}

class Boatsquare{
    int[] location = new int[0];
    boolean hit;

    public Boatsquare(int[] location){
        this.hit = false;
        this.location = location[1];
    }
}

class TestCode{
    public void TestGame(){
        int[] testGridSize = new int[0];
        testGridSize[0] = 1;
        testGridSize[1] = 7;
        Game testGame = new Game(testGridSize);
        System.out.println(Game.printGrid());
        for(int i=0; i<7; i++){
            Game.newInput((String)("b"+i));
            System.out.println(Game.printGrid());
            System.out.println(Game.lastHitStatus());
        }
    }
}

class Game{
    private int[] hitSquaresX = new int[0];
    private int[] hitSquaresY = new int[0];
    private static Boat[] boatArray = new Boat[0];
    private static String currentShotStatus = new String;
    public Game(int[] gridSize){
        int gridX = gridSize[1];
        int gridY = gridSize[0];
        for(int i=0; i<gridY; i++){
            this.boatArray[i] = createBoat(gridX, i);
        }
    }
    public static void newInput(String shotLocation) {
        for (Boat i: boatArray){
            if(i.checkIfHit(shotLocation)){
                i.registerHit(shotLocation);
                currentShotStatus = "hit";
                break;
            }
        }
    }

    public static String printGrid() {
    }

    public static String lastHitStatus() {
    }
    public Boat createBoat(int gridSizeX, int locationY) {
        int boatLength = 3;
        int startLocation = (int) (Math.random()*(gridSizeX-boatLength));
        int[] boatSquaresX = new int[0];
        for (int i=0; i<boatLength; i++) {
            boatSquaresX[i] = startLocation+i;
        }
        Boat newBoat = new Boat(boatSquaresX, locationY);
        return(newBoat);
    }
}

class Boat{
    public Boat(int[] shipSquaresX, int shipSquaresY){

    }
}
