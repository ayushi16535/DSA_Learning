//https://www.techiedelight.com/total-ways-sum-with-n-throws-dice-having-k-faces/
package dp;
public class DiceSum {
    static int recursiveCall=0;
    public static void main(String[] args) {
        int n=4;
        int k=6;
        int sum=12;

        System.out.println(waysToSum(n,k,sum)+"\n"+recursiveCall);
    }

    private static int waysToSum(int n, int k, int sum) {
        recursiveCall++;
        int count=0;
        if(n==0)
            return sum==0?1:0;

        if(sum<0 || n>sum || n*k < sum)
            return 0;

        for (int i = 1; i <=k ; i++) {
            count += waysToSum(n-1,k,sum-i);
        }
        return count;
    }
}
