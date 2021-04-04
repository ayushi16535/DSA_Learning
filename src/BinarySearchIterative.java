public class BinarySearchIterative {
    public static void main(String[] args) {
        int a[]={-1,0,1,2,2,3,4,5,6,7};
        binarySearchIterative(a,1);
    }

    private static void binarySearchIterative(int[] a, int x) {
        int left=0;
        int right=a.length;
        int mid,pos=-1;
        while (left<right){
            mid = (left + right) / 2;
            if (a[mid] == x) {
                pos = mid;
                break;
            }
            else if (a[mid] > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(pos);
    }
}
