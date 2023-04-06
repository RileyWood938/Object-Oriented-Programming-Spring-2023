package assignment.assignment02;

import assignment.encryption_algorithm.Encryption;

public class CeaserCypher implements Encryption {
    private int shiftbits;
    public CeaserCypher (int shiftBits){
        this.shiftbits = shiftBits;
    }

    public String encrypt(String plainText){
        StringBuilder outString = new StringBuilder(plainText.length()); //use a stringbuilder or stringbuffer here

        //StringBuilder and StringBuffer are the same thing except that stringbuffer is synchronised, meaning only
        //one thread at a time can access it. In this case, since i am not intentionally threading this program I dont
        //need to worry about it. It seems like the usecase for stringbuilder and stringbuffer is exculsively when
        // working within loops where many concatenations will occur.

        for (int i = 0; i<plainText.length(); i++){
            char c = plainText.charAt(i);
            outString.append(c+shiftbits);
        }
        return outString.toString();
    }
    public String decrypt(String encryptText){
        StringBuilder outString = new StringBuilder(encryptText.length()); //same here
        for (int i = 0; i<encryptText.length(); i++){
            char c = encryptText.charAt(i);
            outString.append(c-shiftbits);
        }
        return outString.toString();
    }


}
