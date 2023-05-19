package wordSearchers;

import dictionaryManagers.DictionaryManager;

/**
 * This interface is implemented by every algorithm which checks if a word is in a file.
 */
public interface CheckIfWordInDictionary {
    /**
     * checks if the input word exists in the dictionary
     * @param word the word to be checked
     * @return boolean- if the word is or is not in the dictionary
     */
    public boolean isWordInDictionary(String word);

    /**
     * sets the DictionaryManager which this class will use
     * @param dictionaryManager the new dictionaryManager
     */
    public void setDictionaryManager(DictionaryManager dictionaryManager);
}
