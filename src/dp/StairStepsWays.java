//https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
package dp;

public class StairStepsWays {
    public static void main(String[] args) {
        int n=10;
        int m=4;
        System.out.println(totalWays(n,m)+" "+totalWaysDP(n,m));
    }

    private static int totalWays(int n, int m) {

        // base case: invalid input
        if (n < 0) {
            return 0;
        }

        // base case: 1 way (with no steps)
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += totalWays(n - i, m);
        }

        return count;
        }

        static int totalWaysDP(int n,int m){
            int steps[] = new int[n];
            steps[0]=1;
            steps[1]=2;

            for (int i = 2; i <n ; i++) {
                for (int j = (i-m>=0?i-m:0); j <i ; j++) {
                    steps[i] += steps[j];
                }
                steps[i] += i<m?1:0;
            }
            return steps[n-1];
        }

    }

