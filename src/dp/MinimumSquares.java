package dp;

import java.util.Arrays;

//https://www.techiedelight.com/Category/Dynamic-Programming/
public class MinimumSquares {
    static int countRecursion=0;
    static int countRecursionDP=0;

    public static void main(String[] args)
    {
        int n=63;
        int dp[]=new int[n+1];
        dp[0]=0;
        Arrays.fill(dp,-1);
        System.out.println(minSquaresDP1(n)+" "+minSquaresDP2(n,dp)+" "+minSquaresRecursion(n));
        System.out.println(countRecursion+" "+countRecursionDP);
    }

    //bottom-up
    private static int minSquaresDP1(int n) {
       int dp[] = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
            for (int i = 1; i <= Math.floor(Math.sqrt(j)); i++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
            return dp[n];
    }

    //recursion+DP
    private static int minSquaresDP2(int n,int dp[]) {
        countRecursionDP++;
        if(isPerfectSquare(n))
            return 1;
        int count=10000;
        for (int i = 1; i <= Math.floor(Math.sqrt(n)); i++) {
            if(dp[n-i*i]==-1) {
                count = Math.min(count, 1 + minSquaresDP2(n - i * i,dp));
            }
            else
                count=1+dp[n-i*i];
        }
        return dp[n]=count;
    }

    //only recursion
    public static int minSquaresRecursion(int n){
        countRecursion++;
        if(isPerfectSquare(n))
            return 1;
        int count=10000;
        for (int i = 1; i <= Math.floor(Math.sqrt(n)); i++) {
            count = Math.min(count, 1 + minSquaresRecursion(n - i * i));
        }
        return count;
    }



    private static boolean isPerfectSquare(int n) {
            return Math.sqrt(n)==Math.floor(Math.sqrt(n));
    }
}
