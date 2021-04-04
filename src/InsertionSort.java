public class InsertionSort {
    public static void  insertSort(int ar[]){
        int temp,j;
        int n= ar.length;
        for(int i=1;i<n;i++){
            temp=ar[i];
            j=i-1;
            if(ar[j]>temp) {
                while (j >= 0 && ar[j] > temp) {
                    ar[j + 1] = ar[j];
                    j--;

                }
                ar[j + 1] = temp;
            }
            }
        for(int i=1;i<n;i++){
            System.out.println(ar[i]);
        }
    }
    public static void main(String[] args) {
        int ar[]={12,43,21,9,64,30};
        insertSort(ar);
    }
}
