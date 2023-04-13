import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class FindSum {
    public static ArrayList<Integer> findSum(int targetNumber, int[] sumArray) {

        ArrayList<Integer> output = new ArrayList<Integer>();

        ArrayList<Integer> memo = new ArrayList<Integer>();

        for (int i : sumArray) {
            if (i != 0 && targetNumber - i >= 0) {
                if (targetNumber - i == 0) {
                    output.add(i);
                    return output;
                } else if (findSum(targetNumber - i, sumArray, output, memo) != null) {
                    output.add(i);
                    return output;
                }
            }
        }
        return null;
    }
    public static ArrayList<Integer> findSum(int targetNumber, int[] sumArray, ArrayList<Integer> output, ArrayList<Integer> memo) {
       if(memo.contains(targetNumber)){
           return null;
       }
        for (int i : sumArray) {
            if (i != 0 && targetNumber - i >= 0) {
                if (targetNumber - i == 0) {
                    output.add(i);
                    return output;
                } else if (findSum(targetNumber - i, sumArray, output, memo) != null) {
                    output.add(i);
                    return output;
                }
            }
        }
        memo.add(targetNumber);
        return null;
    }
}
