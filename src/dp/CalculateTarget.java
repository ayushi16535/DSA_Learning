//https://www.techiedelight.com/find-ways-calculate-target-elements-array/
package dp;

import java.util.ArrayDeque;
import java.util.Deque;

class Pair{
    Integer num;
    Character sign;

    public Pair(Integer num, Character sign) {
        this.num = num;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "(" + this.sign + ")" + this.num + " ";
    }
}

public class CalculateTarget {
    public static void main(String[] args) {
        int a[]={ 5, 3, -6, 2 };
        int target=6;
        System.out.println(claculateTarget(a,a.length-1,target));
        printWays(a, a.length - 1, 0, target, new ArrayDeque<>());
    }

    //ways to reach target
    private static int claculateTarget(int[] a, int n, int target) {
        int count=0;
        if(target==0)
        {
            return 1;
        }
        if(n < 0)
            return 0;
        count += claculateTarget(a,n-1,target)+claculateTarget(a,n-1,target-a[n]) + claculateTarget(a,n-1,target+a[n]);

        return count;
    }

    //print ways to reach target
    private static void printWays(int a[], int n, int sum, int target, Deque<Pair> list){
        int count = 0;
        if(target==sum)
        {
            printList(list);
            return;
        }
        if(n<0){
            return;
        }
        printWays(a,n-1,sum,target,list);

        list.add(new Pair(a[n],'+'));
        printWays(a,n-1,sum+a[n],target,list);
        list.pollLast();        //backtrack

        list.add(new Pair(a[n],'-'));
        printWays(a,n-1,sum-a[n],target,list);
        list.pollLast(); //backtrack

    }

    private static void printList(Deque<Pair> list) {
        for (Pair p: list) {
            System.out.print(p);
        }
        System.out.println();
    }
}
