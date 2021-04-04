import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static void main(String[] args) {
        int arr[]={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int ans[]=maxWindow(arr,4);
        for (int x: ans) {
            System.out.print(x+" ");
        }
    }

    private static int[] maxWindow(int[] a, int k) {
        int n=a.length;
        int ans[]=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        int i=0;
        for (; i <k ; i++) {
            while (!dq.isEmpty() && a[dq.peekLast()]<=a[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for (; i <n ; i++) {
            ans[i-k]=a[dq.peekFirst()];
            while (!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            while (!dq.isEmpty() && a[dq.peekLast()]<=a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i-k]=a[dq.peekFirst()];
        return ans;
    }
}
