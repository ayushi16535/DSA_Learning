//https://youtu.be/-NTaXJ7BBXs

package dp;

import java.util.Arrays;

public class CoinChange1D
{
    public static void main(String[] args) {
        int coins[]={2,3,5,10};
        int amount=25;
        System.out.println(minCoins(coins,amount));
        int dp[]=new int[amount+1];
        //base condition
        dp[0]=0;
        Arrays.fill(dp,-1);
        System.out.println(minCoinsDP(coins,amount,dp));
        for (int v: dp
             ) {
            System.out.print(v+" ");
        }
    }

    private static int minCoins(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int ans=Integer.MAX_VALUE-1;
        for (int i = 0; i < coins.length; i++) {
            if(amount-coins[i]>=0) {
                int subanswer = minCoins(coins, amount - coins[i]);
                ans=Math.min(subanswer+1,ans);
            }

        }
        return ans;
    }

    private static int minCoinsDP(int[] coins, int amount,int[] dp) {
        if(amount==0)
            return 0 ;
        int ans=Integer.MAX_VALUE-1;
        for (int i = 0; i < coins.length; i++) {
            if(amount-coins[i]>=0 ) {
                int subanswer=0;
                if(dp[amount-coins[i]]!=-1) subanswer=dp[amount-coins[i]];
                else
                    subanswer = minCoinsDP(coins, amount - coins[i], dp);
                ans=Math.min(subanswer+1,ans);
            }
        }
        return dp[amount]=ans;

    }
}
