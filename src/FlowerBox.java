public class FlowerBox {
    public static void main(String[] args) {
//        int nutrients[]={9,10,9};
        int nutrients[]={3,10,3,1,2};
        System.out.println(plantFlowers(nutrients,nutrients.length-1));
        System.out.println(plantFlowersDP(nutrients));
    }

    private static int plantFlowers(int nutrients[],int i) {
       int c=0;
        if(i<0)
           return c;
       int a=nutrients[i]+plantFlowers(nutrients,i-2);
       int b=plantFlowers(nutrients,i-1);
       c=Math.max(a,b);
       return c;
    }

    public static int plantFlowersDP(int nutrients[]){
        int a=0;  //f(i-2)
        int b=0;  //f(i-1)
        int c=0;   //f(i)
        for (int i = 0; i < nutrients.length; i++) {
            c=Math.max(a+nutrients[i],b);
            a=b;
            b=c;
        }
        return c;
    }



}
