//https://www.youtube.com/watch?v=JMxl5rk7kGo&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=58
public class GameTheory {
    public static void main(String[] args) {
        int a[]={1,5,700,3,2,4};
        System.out.println(coinMax(a,0,5));
    }

    static int coinMax(int a[],int l,int r){
        if(l+1==r)
            return Math.max(a[l],a[r]);
        return Math.max(a[l]+Math.min(coinMax(a,l+1,r-1),coinMax(a,l+2,r)),
                a[r]+Math.min(coinMax(a,l+1,r-1),coinMax(a,l,r-2)));
    }
}
