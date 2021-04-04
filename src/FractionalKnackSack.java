//greedy jenny's
//incomplete as it needs to sort both the arrays based on profit/weight ratio
public class FractionalKnackSack {
    public static void main(String[] args) {
        double profits[]={8,5,10,15,9,4,7};
        double weights[]={1,1,3,5,3,2,5};
        int w=15;
        for (int i = 0; i < profits.length; i++) {
            profits[i]=profits[i]/weights[i];
        }

        System.out.println(getMaxProfit(w,weights,profits));
    }

    private static double getMaxProfit(int w, double[] weights, double[] profits) {
        int n=profits.length;
        double weight=0;
        double profit=0;
        int i=n-1;
        while (weight+weights[i]<w){
            profit+=profits[i]*weights[i];
            weight+=weights[i];
            i--;
        }
        weight=w-weight;
        profit+=profits[i]*weight;

        return profit;
    }
}
