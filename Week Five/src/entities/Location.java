package entities;

public class Location {
    private int Xcoordinate;
    private int Ycoordinate;

    //Constructors
    public Location(){
        this.Xcoordinate = 0;
        this.Ycoordinate = 0;
    }
    public Location(int Xcoordinate, int Ycoordinate){
        this.Xcoordinate = Xcoordinate;
        this.Ycoordinate = Ycoordinate;
    }

    //Accessors and Mutators
    public void setXcoordinate(int xcoordinate) {
        Xcoordinate = xcoordinate;
    }
    public void setYcoordinate(int ycoordinate) {
        Ycoordinate = ycoordinate;
    }
    public void moveX(int xmovement){
        Xcoordinate += xmovement;
    }
    public void moveY(int yMovement){
        Ycoordinate += yMovement;
    }
    public int getXcoordinate() {
        return Xcoordinate;
    }
    public int getYcoordinate() {
        return Ycoordinate;
    }

    //ToString
    public String toString(){
        return("X: " + Xcoordinate + ", Y: "+Ycoordinate);
    }
}
