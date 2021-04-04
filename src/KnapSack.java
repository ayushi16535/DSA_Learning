public class KnapSack {

    //KnapSack 0/1 DP jenny's
    public static void main(String[] args) {
        int weights[]={3,4,5,6};
        int profits[]={2,3,4,1};
        int w=10;
        System.out.print("Weights = ");
        Print.printArray(weights);
        System.out.print("Profit = ");
        Print.printArray(profits);
        System.out.println("Maximum profit for "+w+" weight = "+getMaxProfitDP(w,weights,profits));
    }

    private static int getMaxProfitDP(int w, int[] weights, int[] profits) {
        int a[][]=new int[weights.length+1][w+1];
        for (int i = 0; i <=weights.length ; i++) {
            a[i][0]=0;
        }
        for (int i = 0; i <=profits.length; i++) {
            a[0][i]=0;
        }
        int i,j=0;
        for ( i = 1; i <= weights.length; i++) {
            for ( j = 1; j <= w; j++) {
                if(weights[i-1]>j)
                    a[i][j]=a[i-1][j];
                else
                    a[i][j]=Math.max(a[i-1][j],profits[i-1]+a[i][j-weights[i-1]]);
            }

        }
        System.out.print("Best Combination = ");
        Print.printResult(weights,a);
        return a[i-1][j-1];
    }
}
