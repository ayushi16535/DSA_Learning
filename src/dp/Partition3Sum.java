//https://www.techiedelight.com/3-partition-problem/
package dp;

import java.util.Arrays;
import java.util.HashMap;

public class Partition3Sum {
    static int recurson = 0;
    static int recursonDP = 0;
    public static void main(String[] args) {

        int a[] = { 7, 3, 2, 1, 5, 4, 9, 1, 3,2,2 };

        int sum = Arrays.stream(a).sum();

        boolean possible = false;
        boolean possibleDP = false;

        if(sum % 3 == 0) {
            possible = partition(a, a.length - 1, sum / 3, sum / 3, sum / 3);
            possibleDP = partitionDP(a,a.length-1,sum/3,sum/3,sum/3,new HashMap<String, Boolean>());
        }
        System.out.println(possible + " "+recurson);
        System.out.println(possibleDP + " "+recursonDP);
    }

    static boolean partition(int ar[],int n, int a, int b, int c){
        recurson++;
        if(a == 0 && b == 0 && c == 0)
            return true;
        if(n<0)
            return false;

        boolean A = false;
        if(a-ar[n] >= 0)
            A = partition(ar,n-1,a-ar[n],b,c);

        boolean B = false;
        if(!A && b-ar[n] >= 0)
            B = partition(ar,n-1,a,b-ar[n],c);

        boolean C = false;
        if( !A && !B && c-ar[n] >= 0)
            C = partition(ar,n-1,a,b,c-ar[n]);

        return A || B || C;

    }

    static boolean partitionDP(int ar[], int n, int a, int b, int c, HashMap<String,Boolean> lookup){
        recursonDP++;

        if(a == 0 && b == 0 && c == 0)
            return true;

        if(n<0)
            return false;

        String key = a+"|"+b+"|"+c+"|"+n;

        if(!lookup.containsKey(key)) {

            boolean A = false;
            if (a - ar[n] >= 0)
                A = partitionDP(ar, n - 1, a - ar[n], b, c,lookup);

            boolean B = false;
            if (!A && b - ar[n] >= 0)
                B = partitionDP(ar, n - 1, a, b - ar[n], c,lookup);

            boolean C = false;
            if (!A && !B && c - ar[n] >= 0)
                C = partitionDP(ar, n - 1, a, b, c - ar[n],lookup);

            lookup.put(key, A || B || C);
        }

        return lookup.get(key);
    }
}
