package wordSearchers.depricated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/**
 * this class implements a naive word searching algorithm which loops through every word in the given dictionary file
 * and returns true if the given input word matches one in the dictionary.
 *
 * String dictionaryPath points the object towards the file which contains a list of all possible words
 */
public class naiveWordSearch implements CheckIfWordInTextFile {
    static private String dictionaryPath;

    public boolean isWordInDictionary(String word) {
        word = word.strip();
        word = word.toUpperCase(Locale.ROOT);
        try {
            System.out.println("checking word: "+ word + " in file: " + dictionaryPath);
            BufferedReader dictionaryScanner = new BufferedReader(
                    new FileReader(dictionaryPath));
            String line;

            while((line = dictionaryScanner.readLine()) != null) {
                if(line.equals(word)) {
                    System.out.println("Word found");
                    return true;
                }
            }
            System.out.println("Word not found");
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void setDictionaryDirectory(String dictionaryPath) {
        dictionaryPath = dictionaryPath;
    }
}
