import java.util.HashMap;

public class Fibbonacci {

    // Version One: O(n^2) time complexity
//    private static int fib(int n){
//        if(n<=2){
//            return (1);
//        }
//        return (fib(n-1)+fib(n-2));
//    }


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
}
