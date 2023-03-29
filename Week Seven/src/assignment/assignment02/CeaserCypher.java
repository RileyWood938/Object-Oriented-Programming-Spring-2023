package assignment.assignment02;

import assignment.encryption_algorithm.Encryption;

public class CeaserCypher implements Encryption {
    private int shiftbits;
    public CeaserCypher (int shiftBits){
        this.shiftbits = shiftBits;
    }

    public String encrypt(String plainText){
        String outString = ""; //use a stringbuilder or stringbuffer here
        for (int i = 0; i<plainText.length(); i++){
            char c = plainText.charAt(i);
            outString += Character.toString(c+shiftbits);
        }
        return outString;
    }
    public String decrypt(String encryptText){
        String outString = ""; //same here
        for (int i = 0; i<encryptText.length(); i++){
            char c = encryptText.charAt(i);
            outString += Character.toString(c-shiftbits);
        }
        return outString;
    }


}
