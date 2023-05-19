import dictionaryManagers.LengthBasedDictionaryManager;
import frontEnd.CreateFrontEnd;
import wordSearchers.LengthFirstSearch;

public class Main { //wordnet online dictionary
    //lemmatization
    //final:
        //last slide of last lecture node: algorithm example
        //logical errors in code
    //stemming
    //Java swing
    //follow template for final report
    public static void main(String[] args) {
        try {
            CreateFrontEnd frontEnd= new CreateFrontEnd(LengthFirstSearch.class, LengthBasedDictionaryManager.class);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

