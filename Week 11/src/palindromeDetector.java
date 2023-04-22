import java.util.ArrayList;

public class palindromeDetector {
    String palindromeCandidate;
    public boolean isPalendrome;

    public palindromeDetector(String firstPalindrome){
        this.palindromeCandidate = firstPalindrome;
    }

    public void evaluatePalendromeIteratively(){
        for(int i=0; i<palindromeCandidate.length()/2; i++){
            if(palindromeCandidate.charAt(i) != palindromeCandidate.charAt(palindromeCandidate.length()-i-1)) {
                isPalendrome = false;
                return;
            }
        }
        isPalendrome = true;
    }

    public void evaluatePalendromeRecursively(){

        if(firstLastSame(palindromeCandidate)) {

            isPalendrome = true;
        }else {

            isPalendrome = false;
        }
    }

    private boolean firstLastSame(String intakeArray){
        if(intakeArray.length() <=1){

            return true;
        }else{
            if(intakeArray.charAt(0)==intakeArray.charAt(intakeArray.length()-1)){
                return firstLastSame(intakeArray.substring(1, intakeArray.length()-1));
            }else{
                return false;
            }
        }
    }

    private void setPalindromeCandidate(String newWord){
        palindromeCandidate = newWord;
    }
}
