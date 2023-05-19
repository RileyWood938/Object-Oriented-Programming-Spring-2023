package frontEnd;
import dictionaryManagers.DictionaryManager;
import utilities.SpellCheckManager;
import wordSearchers.CheckIfWordInDictionary;

import javax.swing.*;
import java.awt.event.*;


/**
 * Creates the front-end Swing window in which the user can input text. Handles window creation, button creation and updating. Also creates the WordSearcher and DictionaryManager used to spellcheck user input
 */
public class CreateFrontEnd {
    private SpellCheckManager<?, ?> checkManager;


    /**
     * Method to create all the front-end and initialize backend functionality.
     * first creates window with buttons and text. Creates a SpellCheckAction object and applies it to a keybinding which activates it anytime the user inputs "Space" adds actions to the buttons so that they execute their intended functionality
     * called by Main
     * @param searcherType The type of CheckIfWordInDictionary that should be created. takes a class type and requires that it implements the CheckIfWordInDictionary interface (currently only LengthFirstSearch)
     * @param managerType  The type of DictionaryManager that should be created. takes a class type and requires that it implements the DictionaryManager interface (currently only LengthBasedDictionaryManager)
     * @param <T> the type of CheckIfWordInDictionary to expect
     * @param <U> the type of DictionaryManager to expect
     * @throws InstantiationException thrown if it cannot, for some reason instantiate one of the classes it received as parameters
     * @throws IllegalAccessException thrown if it cannot access the classes it received
     */
    public <T extends CheckIfWordInDictionary, U extends DictionaryManager> CreateFrontEnd(Class<T> searcherType, Class<U> managerType) throws InstantiationException, IllegalAccessException {

        checkManager = new SpellCheckManager<>(searcherType, managerType);

        JFrame window=new JFrame("Spellchecker");

        JTextArea textInput=new JTextArea("Type Here");
        textInput.setBounds(50,50, 1820,500);

        JLabel spellcheckLabel = new JLabel("No spelling issues");
        spellcheckLabel.setBounds(50,550,400,30);

        JButton word1=new JButton("Word 1");
        word1.setBounds(50,600,150,30);

        JButton word2=new JButton("Word 2");
        word2.setBounds(220,600,150,30);

        JButton word3=new JButton("Word 3");
        word3.setBounds(390,600,150,30);

        JButton addToDictionary=new JButton("Add To Dictionary");
        addToDictionary.setBounds(50,650,150,30);

        JButton ignoreInDocument=new JButton("Ignore");
        ignoreInDocument.setBounds(220,650,150,30);

        SpellcheckAction checker = new SpellcheckAction(textInput,spellcheckLabel, word1, word2, word3, checkManager);
        word1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textInput.setText(textInput.getText().replaceFirst(checker.currentFail, word1.getText()));
                checker.actionPerformed(e);
            }
        });
        word2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textInput.setText(textInput.getText().replaceFirst(checker.currentFail, word2.getText()));
                checker.actionPerformed(e);
            }
        });
        word3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                textInput.setText(textInput.getText().replaceFirst(checker.currentFail, word3.getText()));
                checker.actionPerformed(e);
            }
        });
        addToDictionary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkManager.addWordToDictionary(checker.currentFail);
                checker.actionPerformed(e);
            }
        });
        ignoreInDocument.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkManager.ignoreWord(checker.currentFail);
                checker.actionPerformed(e);
            }
        });

        textInput.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "spellCheck");


        textInput.getActionMap().put("spellCheck", checker);

        window.add(textInput);window.add(word1);window.add(word2);window.add(word3);window.add(spellcheckLabel);window.add(addToDictionary);window.add(ignoreInDocument);

        window.setSize(1920,1080);

        window.setLayout(null);
        window.setVisible(true);
    }




}
