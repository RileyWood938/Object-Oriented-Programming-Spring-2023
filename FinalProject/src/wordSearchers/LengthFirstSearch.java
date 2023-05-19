package wordSearchers;

import dictionaryManagers.DictionaryManager;
import dictionaryManagers.LengthBasedDictionaryManager;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * CheckIfWordInDicitonary implemented for LengthBasedDictionary
 */
public class LengthFirstSearch implements CheckIfWordInDictionary{
    private HashMap<Integer, TreeSet<String>> dictionary;
    public LengthFirstSearch(){

    }

    /**
     * constructor
     * @param manager the DicitonaryManager to get the dictionary from
     */
    public LengthFirstSearch(DictionaryManager manager){
        this.dictionary = manager.getDictionary();
    }

    /**
     * checks if the word is in the lengthBasedDictionary
     * @param word the word to be checked
     * @return boolean - if the word is or is not in the dictionary
     */
    public boolean isWordInDictionary(String word) {
        if(!dictionary.containsKey(word.length()))
            return false;

        word = word.toUpperCase();
        return dictionary.get(word.length()).contains(word);
    }

    /**
     * sets teh dicitonaryManager
     * @param dictionaryManager the new dictionaryManager
     */
    @Override
    public void setDictionaryManager(DictionaryManager dictionaryManager) {
        this.dictionary = dictionaryManager.getDictionary();
    }

    /**
     * setst the dictionary via data rather than dictionaryManager
     * @param dictionary a lengthBasedDictionary in the form HashMap<Integer, TreeSet<String>>
     */
    public void setDictionary(HashMap<Integer, TreeSet<String>> dictionary){
        dictionary = dictionary;
    }

}
