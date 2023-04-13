import java.util.ArrayList;

public class InSum {
    public static boolean inSum(int targetNumber, int[] sumArray){
        ArrayList<Integer> memo = new ArrayList<Integer>();
        for(int i: sumArray) {
            if (targetNumber - i >= 0 && i!=0) {
                if (targetNumber - i == 0)
                    return true;
                else if (inSum(targetNumber - i, sumArray, memo))
                    return true;
            }
        }
        return false;
    }

    public static boolean inSum(int targetNumber, int[] sumArray, ArrayList<Integer> memo){
        if (memo.contains(targetNumber))
            return false;
        for(int i: sumArray) {
            if (targetNumber>=i && i!=0) {
                if (targetNumber - i == 0)
                    return true;
                else if (inSum(targetNumber - i, sumArray, memo))
                    return true;
            }
        }
        memo.add(targetNumber);
        return false;
    }
}
