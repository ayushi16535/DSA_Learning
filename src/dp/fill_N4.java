//https://www.techiedelight.com/find-ways-fill-n-x-4-matrix-with-1-x-4-tiles/
package dp;

public class fill_N4 {
    public static void main(String[] args) {
        int n=14;
        System.out.println(fillMatrixWays(n)+" "+fill(n));
        int dp[]=new int[n+1];
        System.out.println(fillDP(n,dp));
    }

    //maths
    private static int fillMatrixWays(int n) {
        //all horizontal 1XN
        int count=1;
        int verticalBlocks=n/4;
        //considering each vertical block
        for (int i = 1; i <= verticalBlocks; i++) {
            int horizontal=n-i*4;
            count += fact(horizontal+i)/(fact(horizontal)*fact(i));
        }
        return count;
    }

    static int fact(int n){
        int f=1;
        for(int i=2;i<=n;i++)
            f=f*i;
        return f;
    }

    //recursion
    public static int fill(int n){
        if(n<1)
            return 0;
        if(n<4)
            return 1;
        if(n==4)
            return 2;
        return fill(n-4)+fill(n-1);
    }

    //DP
    public static int fillDP(int n,int dp[]){
        dp[0]=0;
        dp[1]=dp[2]=dp[3]=1;
        dp[4]=2;
        for (int i = 5; i <= n; i++) {
            dp[i] = dp[i-4]+dp[i-1];
        }
        return dp[n];
    }

}
