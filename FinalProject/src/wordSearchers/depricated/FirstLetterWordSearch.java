package wordSearchers.depricated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/**
 * this class implements a naive word searching algorithm which loops through every word in the given dictionary file
 * and returns true if the given input word matches one in the dictionary. It contains a minor optimization which
 * searches only through the words starting with the same first letter as the given input word.
 *
 * String dictionaryDirectory points the object towards the directory which contains a list of files a-z which each
 * contain all words beginning with that letter.
 */
public class FirstLetterWordSearch implements CheckIfWordInTextFile {
    static private String dictionaryDirectory;

    public boolean isWordInDictionary(String word) {
        word = word.strip();
        word = word.toUpperCase(Locale.ROOT);
        String targetDictionary = dictionaryDirectory + word.charAt(0)+"DictOnly.txt";
        try {
            System.out.println("checking word: "+ word + " in file: " + targetDictionary);
            BufferedReader dictionaryScanner = new BufferedReader(
                    new FileReader(targetDictionary));
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
    public static void setDictionaryDirectory(String dictionaryDirectory) {
        FirstLetterWordSearch.dictionaryDirectory = dictionaryDirectory;
    }
}
