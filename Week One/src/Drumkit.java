public class Drumkit {
    boolean topHat = true;
    boolean snare = true;
    void playTopHat(){
        System.out.println("ding ding da-ding");
    }
    void playSnare(){
        System.out.println("bang bang ba-bang");
    }
}
class drumkitTestDrive{
    public static void main(String[] args){
        Drumkit SampleDrumkit = new Drumkit();

        SampleDrumkit.playSnare();

        SampleDrumkit.snare=false;

        if(SampleDrumkit.snare == true){
            SampleDrumkit.playSnare();
        }
        SampleDrumkit.playTopHat();
    }
}