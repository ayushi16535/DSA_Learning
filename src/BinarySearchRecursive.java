public class BinarySearchRecursive {

    public static void main(String[] args) {
        int a[]={2,3,4,5,6,7,8};
        System.out.println(binarySearchRecursive(a,8,0,a.length));
    }

    private static int binarySearchRecursive(int[] a, int x, int left, int right) {
        if(left>right)
            return -1;
        int mid=(left+right)/2;
        if(a[mid]==x)
            return mid;
        else if(a[mid]>x)
            return binarySearchRecursive(a,x,left,mid-1);
        else
            return binarySearchRecursive(a,x,mid+1,right);
    }
}
