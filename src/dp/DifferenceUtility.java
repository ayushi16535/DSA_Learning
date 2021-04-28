//https://www.techiedelight.com/implement-diff-utility/
package dp;

public class DifferenceUtility {

    public static void main(String[] args) {
        String X = "ABCDFGHJQZ";
        String Y = "ABCDEFGIJKRXYZ";

        String lcs=longestCommonSeq(X,Y);
    }

    public static String longestCommonSeq(String x,String y){
        int nx = x.length();
        int ny = y.length();

        int a[][] = new int[nx+1][ny+1];

        for (int i = 1; i <= nx; i++) {
            for (int j = 1; j <= ny; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))
                    a[i][j] = 1 + a[i-1][j-1];
                else
                    a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
            }
        }
//        Print.print2DArray(a);
        String common = printSeq(x,a);
        System.out.println(x+"\n"+y+"\n"+"Largest Common Subsequence ="+common);
        getDifference(x,y,common);
        return "";
    }

    private static void getDifference(String x, String y, String common) {
        int nx = x.length();
        int ny = y.length();
        String str="";
        int i=0,j=0,k=0;
        while (i<nx||j<ny){
            while (i<nx && j<ny && x.charAt(i) == y.charAt(j) && y.charAt(j) == common.charAt(k)){
                str += common.charAt(k);
                i++;
                j++;
                k++;
            }
            if(i<nx && x.charAt(i)!=common.charAt(k)){
                str += "-"+x.charAt(i);
                i++;
            }
            if(j<ny && y.charAt(j) != common.charAt(k)){
                str += "+"+y.charAt(j);
                j++;
            }
        }
        System.out.println(str);
    }

    static String printSeq(String x,int a[][]){
        int rl = a.length;
        int cl = a[0].length;

        int r = rl-1;
        int c = cl-1;

        String result = "";

        while(r !=0 && c != 0){
            while(r>0 && a[r][c] == a[r-1][c])
                r--;
            while (c>0 && a[r][c] == a[r][c-1])
                c--;
            result = x.charAt(r-1)+result;
            r--;
            c--;
        }
        return result;
    }
}
