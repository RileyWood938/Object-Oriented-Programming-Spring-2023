package dictionarySorters;

import java.io.*;

/**
 * This class implements the dictionary sorter method. it takes a file and sorts all the words in it into new text files where each file contains words only starting with a single letter.
 */
public class organizeDictionaryIntoNewFiles implements DictionarySorter{
    /**
     * The sorting method. The filepath entered will be the directory of the new dictionaries, and it will contain 26 files named A.txt, B.txt ect
     * @param dictionaryFileName  the filePath of the dictionary to be changed
     * @param destinationFileName the directory of the new dictionaries
     */
    public void sortDictionary(String dictionaryFileName, String destinationFileName) {
        try {
            String destinationFilePath = destinationFileName.substring(0, destinationFileName.lastIndexOf(".")) + "\\";
            for (int i = 0; i <= 25; i++) {
                BufferedReader dictionaryScanner = new BufferedReader(
                        new FileReader(dictionaryFileName));
                String line = "";
                char c = (char) (65 + i);

                BufferedWriter writer = new BufferedWriter(new FileWriter((destinationFilePath + Character.toString(c) + destinationFileName.substring(destinationFileName.lastIndexOf(".")))));

                while ((line = dictionaryScanner.readLine()) != null) {
                    if (line.charAt(0) == Character.toUpperCase(c)) {
                        writer.write(line + "\n");
                    }
                }
                dictionaryScanner.close();
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
