package dictionaryManagers;

import dictionarySorters.DictionarySorter;

import java.io.*;
import java.util.*;

/**
 * This dictionary manager handles the LengthBased dicitonary.
 * This type of dictionary sorts words by length, then buts them into a treeSet so that they are sorted alphabetically.
 * it implements DictionaryManager and DictionarySorter which both create methods for getting dictionaries from and saving them to files.
 * Instances of this class are created by the SpellCheckManager class
 */
public class LengthBasedDictionaryManager implements DictionarySorter, DictionaryManager{
    private HashMap<Integer, TreeSet<String>> dictionary;

    /**
     * Simple constructor, creates a LengthBasedDictionaryManager with no dictionary or other information. This method is what is used by SpellCheckManager
     */
    public LengthBasedDictionaryManager(){};

    /**
     * More complex constructor. Loads a dictionary from file when activated
     * @param dictionaryFilePath the filePath of the dictionary to be loaded
     */
    public LengthBasedDictionaryManager(String dictionaryFilePath){
        getDictionaryFromFile(dictionaryFilePath);
    }

    /**
     * SortDicitonary method sorts a generic dictionary text file and saves it as a lengthBasedDictionary text file
     * @param dictionaryFileName the filepath of the generic text file to be sorted
     * @param destinationFileName the filepath of the new dicitonary
     */
    public void sortDictionary(String dictionaryFileName, String destinationFileName){
        getDictionaryFromGenericFile(dictionaryFileName);
        saveDictionaryToFile(destinationFileName);
    }

    /**
     * Gets a dictionary from a generic file (Generic referring to the file simply being a list of valid strings, unsorted)
     * @param dictionaryPath the filepath of the generic dictionary to be loaded
     */
    public  void getDictionaryFromGenericFile(String dictionaryPath){
       HashMap<Integer, TreeSet<String>> output = new HashMap<Integer, TreeSet<String>>();
        try {
            for (int i = 0; i <= 25; i++) {
                BufferedReader dictionaryScanner = new BufferedReader(
                        new FileReader(dictionaryPath));
                String line = "";

                while ((line = dictionaryScanner.readLine()) != null) {
                    if(output.containsKey(line.length())) {
                        output.get(line.length()).add(line);
                    }else{
                        TreeSet<String> tempList = new TreeSet<>();
                        tempList.add(line);
                        output.put(line.length(),tempList);
                    }
                }
                dictionaryScanner.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dictionary = output;
    }

    /**
     * Saves a length based dicitonary to file, sorted by word-length and alphabetized for quick retrieval.
     * @param dictionaryFilePath the filePath of the new dictionary to be saved
     */
    public void saveDictionaryToFile(String dictionaryFilePath){
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(dictionaryFilePath));


            for (Map.Entry<Integer, TreeSet<String>> entry : dictionary.entrySet()) {
                Integer key = entry.getKey();
                TreeSet<String> value = entry.getValue();
                writer.write(key + "\n");
                writer.write(value.toString() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a lengthBased dictionary from a lengthBasedDictionary file as created by saveDictionaryToFile. expects a text file with words stored by length and alphabetized.
     * @param dictionaryFilePath the filePath of the lengthBasedDictionary to load
     */
    public void getDictionaryFromFile(String dictionaryFilePath){
        HashMap<Integer, TreeSet<String>> output = new HashMap<Integer, TreeSet<String>>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(dictionaryFilePath));
            String line = "";
            int currentIndex = 0;

            while((line = reader.readLine()) != null){
                line=line.strip();
                if(Character.isDigit(line.charAt(0))){
                    currentIndex = Integer.parseInt(line);
                    output.put(currentIndex, new TreeSet<String>());
                }else{
                    String[] lineAsArray = line.substring(1, line.length()-1).split(",");
                    for (String i:lineAsArray) {
                        output.get(currentIndex).add(i.strip());
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dictionary = output;
    }

    /**
     * adds a word to dicitonary. The word is added to the HashMap<Integer, TreeSet<String>> in memory, then the dicitonary is saved to file with the new word included (permanently alters the dicitonary)
     * if a word is already in the dictionary it is ignored since treeSets cannot have duplicate items
     * @param word the word to be added
     */
    public void addWordToDictionary(String word){
        dictionary.get(word.strip().length()).add(word.strip().toUpperCase());
    }

    /**
     * returns the HashMap<Integer, TreeSet<String >> dictionary format. Used by the LengthFirstSearch
     * @return  returns the HashMap<Integer, TreeSet<String >> dictionary
     */
    public HashMap<Integer, TreeSet<String >> getDictionary(){
        return dictionary;
    }


}
