//https://www.youtube.com/watch?v=cETfFsSTGJI
//https://www.techiedelight.com/find-minimum-jumps-required-reach-destination/
package dp;

import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
//        int a[]={ 4, 2, 0, 3, 2, 0, 1, 8 };
        int a[]= {2,3,1,1,2,4,2,0,1,1};
        System.out.println(minJumps(a));
    }

    private static int minJumps(int[] a) {
        int n = a.length;
        int jumps[] = new int[n];
        int actualJump[] = new int[n];
        Arrays.fill(jumps,10000);
        jumps[0]=0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] >= i - j) {
                    if(jumps[i]>1+jumps[j]) {
                        jumps[i] = 1+jumps[j];
                        actualJump[i] = j;
                    }
                }
            }
        }
        int pos=n-1;
        String path="->"+a[n-1];
        while(pos != 0){
            path = "->"+a[actualJump[pos]]+path;
            pos = actualJump[pos];
        }
        System.out.println(path);

        return jumps[n-1];
    }
}
