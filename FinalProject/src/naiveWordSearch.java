import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class naiveWordSearch implements checkIfWordInDictionary {
    static public String dictionaryFileName;
    public static boolean IsWordInDictionary(String word) {
        word.toLowerCase();
        word.strip();
        try {
            BufferedReader dictionaryScanner = new BufferedReader(
                    new FileReader(dictionaryFileName));
            String line;
            while((line = dictionaryScanner.readLine()) != null) {
                if(line.contains(" ") == false) {
                    line = line.toLowerCase(Locale.ROOT);
                        if(line.contains(word) == true){
                            System.out.println(line);
                            return true;
                        }
                    }
                }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//try (BufferedReader reader = new BufferedReader(new FileReader("filename.txt"))) {
//            String word;
//            while ((word = reader.readLine()) != null) {
//                // Do something with each line, such as print it
//                System.out.println(word);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
        return false;
    }
}
