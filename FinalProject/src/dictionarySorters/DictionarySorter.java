package dictionarySorters;

/**
 * This Interface is used by all classes which seek to sort a list of words for use as a dictionary. It includes a
 * single method which sorts a dictionary and saves the result to a file.
 */
public interface DictionarySorter {
    /**
     * loads a dictionary and then saves it to another file location after doing some operation on it
     * @param dictionaryFileName the filePath of the dictionary to be changed
     * @param destinationFileName the filepath of the new dictionary
     */
    public void sortDictionary(String dictionaryFileName, String destinationFileName);

}
