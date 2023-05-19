package dictionarySorters;

import java.io.*;
import java.util.Locale;


/**
 * This class sorts through a dictionary text file to return a "clean" version of the dictionary.
 */
public class SortDictionaryByFirstLetter implements DictionarySorter{
    /**
     * takes a dictionary txt file and sorts through it, creating a new txt file which contains no word definitions and is in alphabetical order.
     * @param dictionaryFileName  the filePath of the dictionary to be changed
     * @param destinationFileName the filepath of the new dictionary
     */
    public void sortDictionary(String dictionaryFileName, String destinationFileName) {
        String lastLine = "";
        try {
            BufferedReader dictionaryScanner = new BufferedReader(
                    new FileReader(dictionaryFileName));
            String line;

            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName));


            while ((line = dictionaryScanner.readLine()) != null) {
                line = line.strip();
                if (!line.isBlank()) {
                    if (line.equals(line.toUpperCase(Locale.ROOT))) {
                        if (!containsNumber(line)) {
                            if (!line.equals(lastLine)) {
                                lastLine = line;
                                if (line.contains(";")) {
                                    writer.write(line.split(";")[0] + "\n");
                                    writer.write(line.split(";")[1] + "\n");
                                } else {
                                    writer.write(line + "\n");
                                }
                            }
                        }
                    }
                }
            }
            writer.close();
            dictionaryScanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static private boolean containsNumber(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
