import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String a1= "abaaba";//"aabaaaba";
        String a2="babbab";//"baabaaababa";
        System.out.println("Longest common subsequence in strings\n"+a1+"\n"+a2+"\n"+getLongestSubsequence(a1,a2));
    }

    private static int getLongestSubsequence(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        int a[][]=new int[n1+1][n2+1];
        boolean flag[][]=new boolean[n1+1][n2+1];
        for (int i = 0; i <=n1 ; i++) {
            a[i][0]=0;
        }
        for (int i = 0; i <=n2 ; i++) {
            a[0][i]=0;
        }
        int i,j=0;
        for ( i = 1; i <=n1; i++) {
            for ( j = 1; j <=n2 ; j++) {
               if(s1.charAt(i-1)==s2.charAt(j-1)) {
                   a[i][j] = 1 + a[i - 1][j - 1];
                   flag[i][j]=TRUE;
               }
               else {
                   a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
                   flag[i][j]=FALSE;
               }
            }
        }
        Print.print2DArray(a);
        printSequence(s1,s2,a,flag);
        return a[i-1][j-1];
    }

    private static void printSequence(String s1,String s2,int[][] a,boolean flag[][]) {
        int n1=a.length;
        int n2=a[0].length;
        String seq="";
        int row=n1-1;
        int col=n2-1;
        while(row>0&&col>0)
        {
            if(flag[row][col]){
                seq = s1.charAt(row-1)+seq;
                row--;
                col--;
            }
            else{
                if(a[row][col]==a[row-1][col])
                    row--;
                else
                    col--;

            }
        }
        System.out.println("Common sequence = "+seq);
    }
}
