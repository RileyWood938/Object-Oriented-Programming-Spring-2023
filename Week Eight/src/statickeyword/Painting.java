package statickeyword;

import java.util.stream.Stream;

public class Painting {
    private float height;
    private float width;
    private String name;
    private static String artist;

    public Painting(float height, float width, String name){
        this.height = height;
        this.width = width;
        this.name = name;
    }

    public static void setArtist(String artist){
        Painting.artist = artist;
    }

    public static String getArtist(){
        return artist;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return ("This painting is called " + name + " by " + artist);
    }
}
