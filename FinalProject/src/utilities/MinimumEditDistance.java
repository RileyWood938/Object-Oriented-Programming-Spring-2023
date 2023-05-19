package utilities;

import java.security.PublicKey;

import static java.lang.Math.min;

/**
 * Class which contains the functionality to find the minimum distance between two words
 */
public class MinimumEditDistance {
    private String word1;
    private String word2;
    private int[][] editTable;
    private int minimumDistance;

    /**
     * simple constructor. Takes two words to compare and fills the minimumEditDistance table ato find their edit distance.
     * @param inputWord the first word to compare
     * @param targetWord the second word to compare
     */
    public MinimumEditDistance(String inputWord, String targetWord){
        this.word1 = " " + inputWord;
        this.word2 = " " + targetWord;
        this.editTable = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word2.length(); i++){
            editTable[0][i] = i;
        }
        for (int j=0; j<word1.length(); j++){
            editTable[j][0] = j;
        }
        fillTable();
    }

    /**
     * Fills the minimum edit distance table according to the algorithm discussed below:
     * https://www.youtube.com/watch?v=We3YDTzNXEk
     */
    private void fillTable(){
        for (int i = 1; i < word2.length(); i++) {
            for (int j = 1; j < word1.length(); j++) {

                if(word1.charAt(j) == word2.charAt(i)){
                    editTable[j][i] = editTable[j-1][i-1];
                }
                else {
                    editTable[j][i] = Math.min(Math.min(editTable[j - 1][i], editTable[j - 1][i - 1]), editTable[j][i - 1]) + 1;
                }
//                if(word1.charAt(j) != word2.charAt(i))
//                    editTable[j][i] +=1;
//                else if(j>word2.length()-1)
//                    editTable[j][i] +=1;
//                else if(i>word1.length()-1)
//                  editTable[j][i] +=1;

            }
        }
        this.minimumDistance = editTable[word1.length()-1][word2.length()-1];
    }

    /**
     * prints the minimum edit distance table for error checking
     */
    public void print(){
        System.out.println(" "+ " " + word1);
        for(int i=0; i<word2.length(); i++){
            System.out.print(word2.charAt(i));
            System.out.print(" ");
            for (int j = 0; j < word1.length(); j++) {
                System.out.print(editTable[j][i]);
            }
            System.out.print("\n");
        }
    }

    /**
     * @return returns the minimum distance between the two words word1, word2
     */
    public int getMinimumDistance() {
        return minimumDistance;
    }

    /**
     * changes one of the words and then reloads the editTable
     * TODO: figure out why fillTable is being called twice
     * @param word the new word1 (to be compared to word2)
     */
    public void setWord1(String word){
        word1 = " " + word;
        this.editTable = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word2.length(); i++){
            editTable[0][i] = i;
        }
        for (int j=0; j<word1.length(); j++){
            editTable[j][0] = j;
        }
        fillTable();
        fillTable();
    }
    /**
     * changes one of the words and then reloads the editTable
     * TODO: figure out why fillTable is being called twice
     * @param word the new word2 (to be compared to word1)
     */
    public void setWord2(String word){
        word2 = " " + word;
        this.editTable = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word2.length(); i++){
            editTable[0][i] = i;
        }
        for (int j=0; j<word1.length(); j++){
            editTable[j][0] = j;
        }
        fillTable();
        fillTable();
    }

    /**
     * @return returns word1
     */
    public String getWord1(){
        return word1;
    }

    /**
     * @return  returns word2
     */
    public String getWord2(){
        return word2;
    }

    /**
     * @return returns the editTable as a matrix int[][]
     */
    public int[][] getEditTable(){
        return editTable;
    }
}
