package dictionaryManagers;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * This interface creates the templates for Dictionary Managers.
 * Objects implementing this should be able to get and save a type of dictionary from a file.
 * They are used to load the dictionary into memory for use by other parts of the program.
 * TODO: remove getDictionary() method so that interface does not require dictionaries be saved in any particular format
 */
public interface DictionaryManager {
    void getDictionaryFromGenericFile(String dictionaryPath);
     void saveDictionaryToFile(String dictionaryFilePath);
     void getDictionaryFromFile(String dictionaryFilePath);
     void addWordToDictionary(String word);
     HashMap<Integer, TreeSet<String >> getDictionary();

}
