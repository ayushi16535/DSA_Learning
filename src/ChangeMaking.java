//jenny's
public class ChangeMaking {
    public static void main(String[] args) {
        int coins[]={2,3,5,10};
        int amount=15;
        String coinArray="[";
        for (int i = 0; i < coins.length; i++) {
            coinArray+=coins[i]+",";
        }
        coinArray+="]";
        System.out.println("Coins = "+coinArray+"\nSum = "+amount+" is possible in "+ getAllCombinationsDP(amount,coins)+" ways");
        System.out.println("Coins = "+coinArray+"\nSum = "+amount+" is possible in minimum "+ getMinimunCoinsDP(amount,coins)+" coins");
    }

    private static int getAllCombinationsDP(int amount, int[] coins) {
        int n=coins.length;
        int i,j=0;
        int a[][]=new int[n+1][amount+1];
        for (int k = 0; k <= n; k++) {
            a[k][0]=1;
        }
        for (int k = 1; k <=amount; k++) {
            a[0][k]=0;
        }
        for ( i = 1; i <=n; i++) {
            for ( j = 1; j <= amount; j++) {
                if(coins[i-1]>j) {
                    a[i][j] = a[i - 1][j];
                }
                else
                    a[i][j]=a[i-1][j]+a[i][j-coins[i-1]];
            }

        }
        return a[i-1][j-1];
    }

    private static int getMinimunCoinsDP(int amount,int coins[]){
        int n=coins.length;
        int a[][]=new int[n+1][amount+1];
        for (int i = 0; i <n ; i++) {
            a[i][0]=0;
        }
        for (int k = 1; k <=amount; k++) {
            a[0][k]=100;
        }
        int i,j=0;
        for ( i = 1; i <=n ; i++) {
            for ( j = 1; j <=amount ; j++) {
                if(j<coins[i-1])
                    a[i][j]=a[i-1][j];
                else
                    a[i][j]=Math.min(a[i-1][j],1+a[i][j-coins[i-1]]);
            }
        }
        return a[i-1][j-1];
    }
}
