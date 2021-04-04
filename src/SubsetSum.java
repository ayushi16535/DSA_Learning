import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

//jenny's DP
public class SubsetSum {

    public static void main(String[] args) {
        int set[]={2,3,5,7,10};
        int w=15;
        System.out.print("Subset of Sum of "+w+" in set = ");
        Print.printArray(set);
        System.out.println("Possible = "+isPresentSubsetWithSum(w,set));
    }

    private static boolean isPresentSubsetWithSum(int w, int[] set) {
        int n=set.length;
        boolean a[][]=new boolean[n+1][w+1];
        for (int i = 0; i <=n ; i++) {
            a[i][0]=TRUE;
        }
        for (int i = 1; i <=w ; i++) {
            a[0][i]=FALSE;
        }
        int i,j=0;
        for (i = 1; i <=n ; i++) {
            for (j = 1; j <=w ; j++) {
                if(j<set[i-1])
                    a[i][j]=a[i-1][j];
                else
                    a[i][j]=a[i-1][j]||a[i-1][j-set[i-1]];
            }
        }
        if(a[i-1][j-1])
            printResult(set,a);
        return a[i-1][j-1];
    }

    public static void printResult(int set[],boolean a[][]){
        int j=a[0].length-1;
        int i=a.length-1;
        String result="[";
        while (i>0) {
            while (i>0&&a[i][j]) {
                i--;
            }
            if(i>0) {
                result += set[i] + ",";
                j =j - set[i];
            }
        }
        result+="]";
        System.out.println(result);
    }
}
