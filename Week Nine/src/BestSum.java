import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {


    public static ArrayList<Integer> BestSum(int targetNumber, int[] numbersToSum) {
        ArrayList<Integer> bestSoFar = new ArrayList<Integer>();

        HashMap<Integer, ArrayList<Integer>> memo = new  HashMap<Integer, ArrayList<Integer>>();

        if(targetNumber<0)
            return null;

        if (targetNumber == 0)
            return bestSoFar;

        for (int i : numbersToSum) {
            if (i != 0) {
                ArrayList<Integer> memoRefernece =(BestSum(targetNumber-i, numbersToSum, memo));
                if(memoRefernece != null){
                    ArrayList<Integer> currentAnswer = new ArrayList<Integer>(memoRefernece);
                    currentAnswer.add(i);
                    if(bestSoFar.size() == 0)
                        bestSoFar = currentAnswer;
                    else if(currentAnswer.size()<=bestSoFar.size())
                        bestSoFar = currentAnswer;
                }
            }
        }
        if(bestSoFar.size() ==0){
            memo.put(targetNumber, null);
        }else{
            memo.put(targetNumber, bestSoFar);
        }
        return memo.get(targetNumber);
    }

    public static ArrayList<Integer> BestSum(int targetNumber, int[] numbersToSum,  HashMap<Integer, ArrayList<Integer>> memo) {
        ArrayList<Integer> bestSoFar = new ArrayList<Integer>();

        if (targetNumber == 0)
            return bestSoFar;

        if(targetNumber<0)
            return null;

        if(memo.containsKey(targetNumber)){
            return memo.get(targetNumber);
        }

        for (int i : numbersToSum) {
            if (i != 0) {
                ArrayList<Integer> memoRefernece =(BestSum(targetNumber-i, numbersToSum, memo));
                if(memoRefernece != null){
                    ArrayList<Integer> currentAnswer = new ArrayList<Integer>(memoRefernece);
                    currentAnswer.add(i);
                    if(bestSoFar.size() == 0)
                        bestSoFar = currentAnswer;
                    else if(currentAnswer.size()<=bestSoFar.size())
                        bestSoFar = currentAnswer;
                }
            }
        }
        if(bestSoFar.size() ==0){
            memo.put(targetNumber, null);
        }else{
            memo.put(targetNumber, bestSoFar);
        }
        return memo.get(targetNumber);
    }
}

