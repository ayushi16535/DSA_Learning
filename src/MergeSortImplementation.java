public class MergeSortImplementation {

    public static void mergeSort(int a[],int lb,int ub){
        if(lb<ub){
            int mid=(lb+ub)/2;
            mergeSort(a,lb,mid);
            mergeSort(a,mid+1,ub);
            merge(a,lb,mid,ub);
        }
    }
    public static void merge(int a[],int lb,int mid,int ub){
        int i=lb;
        int j=mid+1;
        int k=0;
        int len=ub-lb+1;
        int b[]=new int[len];
        while(i<=mid&&j<=ub) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        while (i<=mid)
            b[k++] = a[i++];
        while(j<=ub)
            b[k++] = a[j++];

        for (int l = 0; l < len; l++) {
            a[lb+l]=b[l];
        }
    }

    public static void main(String[] args) {
        int a[]={10,23,2,32,9,8,4,42};
        mergeSort(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }

}
