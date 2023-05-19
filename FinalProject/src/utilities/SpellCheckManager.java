package utilities;

import dictionaryManagers.DictionaryManager;
import utilities.MinimumEditDistance;
import wordSearchers.CheckIfWordInDictionary;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Spellcheck manager handles the interface between inimumEditDistance, DictioaryManager, and CheckIfWOrdInDictionary. It is written generically so that regardless of what type of dictionary is being used, it can still function given they implement the correct interfaces
 * @param <T>
 * @param <U>
 */
public  class SpellCheckManager<T extends CheckIfWordInDictionary, U extends DictionaryManager>{
    ArrayList<String> validWords;
    Class<U> managerType;
    U dictionaryManager;
    Class<T> searcherType;
    T searcher;
    private MinimumEditDistance editDistanceFinder;

    /**
     * Constructor. Creates a new DictionaryManager and CheckIFWordInDictionary and stores them
     * @param searcherType The type of searcher to be used (A class type which must match the generic type T and extend CheckIfWordInDictionary)
     * @param managerType The type of manager to be used (A class type which must match the generic type U and extend DictionaryManager)
     * @throws InstantiationException thrown if it cannot instantiate one of the classes passed to it
     * @throws IllegalAccessException thrown if it cannot access one of the classes passed to it
     */
    public SpellCheckManager(Class<T> searcherType, Class<U> managerType) throws InstantiationException, IllegalAccessException {
        editDistanceFinder = new MinimumEditDistance(" ", " ");
        this.validWords = new ArrayList<String >();
        this.dictionaryManager = managerType.newInstance();
        dictionaryManager.getDictionaryFromFile("src/dictionaries/LengthBasedDictionary.txt");
        this.searcherType = searcherType;
        this.searcher = searcherType.newInstance();
        searcher.setDictionaryManager(dictionaryManager);
    }

    /**
     * loops through all of textToCheck. If a word is in a lsit of approved words (if it has been previously checked), it is ignored. Otherwise, CheckIfWordInDictionary is used to check if the word is cvalid. if it is, that word is added to the list of validated words and the program moves on. otherwise it returns the first invalid word not in the list.
     * If all words are correct and/or in the list of validWords, it returns null
     * @param textToCheck the text to be searched through
     * @return returns the first weord spelled incorrectly and not ignored. if no such word exists returns null.
     */
    public String getFirstInvalidWord(String textToCheck){
        String[] wordsIn = textToCheck.split("\\W+");

        for(String i: wordsIn) {
            i=i.strip();
            if (!validWords.contains(i)) {
                if (searcher.isWordInDictionary(i)) {
                    validWords.add(i);
                } else {
                    return i;
                }
            }
        }
    return null;
    }

    /**
     * Searches through the dictionary to find the closest matches to the input word.
     * considers the length of the word being corrected and searches within an expanding scope.
     * If there are at least three words with the same length and a minimum edit distance of 1 from the input word it returns those.
     * If not, it examines words with lengths one greater and one smaller than the input word. If this search does not yield a minimum of three results, the algorithm proceeds to minimum edit distance of 2 from the original word. This process continues until three matching words are obtained.
     * @param wordToMatch the word to find the closest matches to
     * @return returns an ArrayList of at least three words with the lowest edit distance from the input
     */
    public ArrayList<String> getClosestWords(String wordToMatch){
        ArrayList<String> output = new ArrayList<String>();
        editDistanceFinder.setWord1(wordToMatch.toUpperCase());
        int k=0;
        int j=0;
        while(output.size()<3) {
            j++;
            while (output.size() < 3) {
                k++;
                TreeSet<String> tree = dictionaryManager.getDictionary().get(wordToMatch.length());
                for (String i : tree) {
                    editDistanceFinder.setWord2(i.toUpperCase());
                    if (editDistanceFinder.getMinimumDistance() == k) {
//                        System.out.print(i);
//                        System.out.println(editDistanceFinder.getMinimumDistance());
                        output.add(i);
                    }
                }

                if((tree = dictionaryManager.getDictionary().get(wordToMatch.length() + j)) != null) {
                    for (String i : tree) {
                        editDistanceFinder.setWord2(i.toUpperCase());
                        if (editDistanceFinder.getMinimumDistance() == k) {
//                            System.out.print(i);
//                            System.out.println(editDistanceFinder.getMinimumDistance());
                            output.add(i);
                        }
                    }
                }
                if((tree = dictionaryManager.getDictionary().get(wordToMatch.length() - j)) != null) {
                    for (String i : tree) {
                        editDistanceFinder.setWord2(i.toUpperCase());
                        if (editDistanceFinder.getMinimumDistance() == k) {
//                            System.out.println(i);
//                            System.out.println(editDistanceFinder.getMinimumDistance());
                            output.add(i);
                        }
                    }
                }
            }
        }
//
//        int k=0;
//        while (output.size()<3) {
//            k++;
//            for (String i : dictionaryManager.getDictionary().get(wordToMatch.length())) {
//                editDistanceFinder.setWord2(i);
//                if (editDistanceFinder.getMinimumDistance() == 1) {
//                    output.add(i);
//                    System.out.println(i);
//
//                }
//            }
//            int i = 0;
//            while (i < 2 & output.size()<3) {
//                i++;
//                for (String j : dictionaryManager.getDictionary().get(wordToMatch.length() + i)) {
//                    editDistanceFinder.setWord2(j);
//                    if (editDistanceFinder.getMinimumDistance() == k) {
//                        output.add(j);
//                        System.out.println(j);
//
//                    }
//                }
//                for (String j : dictionaryManager.getDictionary().get(wordToMatch.length() - i)) {
//                    editDistanceFinder.setWord2(j);
//                    if (editDistanceFinder.getMinimumDistance() == k) {
//                        output.add(j);
//                        System.out.println(j);
//
//                    }
//                }
//            }
//        }
        return output;
    }

    /**
     * adds a word to dicitonary via the dictionaryManagers addWordToDictionary method. This permanently altars the dicitonary and will be saved between runs of the program
     * @param word the word to be added to dictionary
     */
    public void addWordToDictionary(String word){
        dictionaryManager.addWordToDictionary(word);
        dictionaryManager.saveDictionaryToFile("src/dictionaries/LengthBasedDictionary.txt");
        dictionaryManager.getDictionaryFromFile("src/dictionaries/LengthBasedDictionary.txt");
    }

    /**
     * adds a word to an ignore list (validWords). This word will be considered correct until the program is terminated at which point it will again be viewed as incorrect
     * @param word the word to be ignored
     */
    public void ignoreWord(String word){
        validWords.add(word);
    }

}

