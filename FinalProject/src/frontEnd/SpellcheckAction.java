package frontEnd;

import utilities.SpellCheckManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Used to detect when the user has entered an invalid word. Created and bound in CreateFrontEnd
 */
public class SpellcheckAction extends AbstractAction {
    private JTextArea textArea;
    private JLabel label;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private SpellCheckManager<?,?> checkManager;
    public String currentFail;

    /**
     * Creates the SpellCheckAction object. takes various elements of the front-end in order to change them when needed
     * @param text the JTextArea to search through for misspellings
     * @param label the label which states if there are any misspellings and what they are
     * @param button1 the first correction option
     * @param button2 the second correction option
     * @param button3 the third correction option
     * @param checkManager the SpellcheckManager which it will use to check if words are correct
     */
    public SpellcheckAction(JTextArea text, JLabel label, JButton button1, JButton button2, JButton button3, SpellCheckManager<?,?> checkManager) {
        this.currentFail = "";
        this.textArea = text;
        this.label = label;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.checkManager = checkManager;
    }

    /**
     * Looks through the contents of the textArea. If there is a misspelling, it sets the currentFail to that word and proceeds to use the spellcheckManager to find the closest words.
     * changes the various buttons to contain the correct words. Shoudl also ensure that words which are uppercase remain uppercase (TODO: make sure this actually works)
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if((currentFail = checkManager.getFirstInvalidWord(textArea.getText())) !=null){
            label.setText("Correcting: " + currentFail);
            ArrayList<String> matchingWords = checkManager.getClosestWords(currentFail);
            if(Character.isUpperCase(currentFail.charAt(0))){
                button1.setText(Character.toString(Character.toUpperCase(matchingWords.get(0).charAt(0))) +matchingWords.get(0).toLowerCase().substring(1));
                button2.setText(Character.toString(Character.toUpperCase(matchingWords.get(1).charAt(0))) +matchingWords.get(0).toLowerCase().substring(1));
                button3.setText(Character.toString(Character.toUpperCase(matchingWords.get(2).charAt(0))) +matchingWords.get(0).toLowerCase().substring(1));
            }
            button1.setText(matchingWords.get(0).toLowerCase());
            button2.setText(matchingWords.get(1).toLowerCase());
            button3.setText(matchingWords.get(2).toLowerCase());
        }else{
            label.setText("No spelling issues");
        }
    }
}

