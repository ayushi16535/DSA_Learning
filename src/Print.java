public class Print {
    public static void printArray(int a[]){
        String array="[";
        for (int i = 0; i < a.length; i++) {
            array+=a[i]+",";
        }
        array+="]";
        System.out.println(array);
    }


    public static void printResult(int option[],int a[][]){
        int j=a[0].length-1;
        int i=a.length-1;
        String result="[";
        int temp;
        while (a[i][j]!=0) {
            temp=a[i][j];
            while (a[i][j] == temp) {
                i--;
            }
            result+=option[i]+",";
            j= (i>0)?j-option[i - 1]:j;
        }
        result+="]";
        System.out.println(result);
    }
    public static void print2DArray(int a[][]){
        int i=a.length;
        int j=a[0].length;
        for (int k = 0; k <i; k++) {
            for (int l = 0; l <j; l++) {
                System.out.print(a[k][l]+",");
            }
            System.out.println();
        }
    }
}
