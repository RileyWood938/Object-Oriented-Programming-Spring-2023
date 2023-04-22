import java.util.Arrays;
import java.util.HashMap;

public class Fibbonacci {

    // Version One: O(n^2) time complexity
    private static int fibBad(int n){
        if(n<=2){
            return (1);
        }
        return (fib(n-1)+fib(n-2));
    }


    // Memoized version: more effecient

    public static int fib(int n){
        if(n<=2)
            return(1);
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        memo.put(n, (fib(n-1, memo)+fib(n-2, memo)));
        return (memo.get(n));
    }
    public static int fib(int n, HashMap<Integer, Integer> memo){
        if(memo.get(n) != null)
            return memo.get(n);
        if(n<=2) {
            return 1;
        }
        memo.put(n, (fib(n-1, memo)+fib(n-2, memo)));
        return (memo.get(n));
    }

    //Tabulated verison

    public static int fibTab(int n){
        n+=1;
        if(n<2){
            throw new RuntimeException("enter a positive value");
        }
        int[] fibSequence = new int[n];
        fibSequence[1] = 1;


        for (int i=0; i+2<n; i++){
            fibSequence[i+1] += fibSequence[i];
            fibSequence[i+2] += fibSequence[i];
        }

//        fibSequence[n-2] += fibSequence[n-3];
        fibSequence[n-1] += fibSequence[n-2];


        System.out.println(Arrays.toString(fibSequence));
        return fibSequence[n-1];

    }
}
