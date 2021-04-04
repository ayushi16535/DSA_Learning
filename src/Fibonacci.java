public class Fibonacci {
    public static void main(String[] args) {
        // 0 1 1 2 3 5 8 13
        int n=8;
        System.out.println("Fib["+n+"] = "+fib(n));
        System.out.println("Fib["+n+"] = "+fibMemory(n));
        System.out.println("Fib["+n+"] = "+fibDP(n));
    }

    private static int fib(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        return fib(n-1)+fib(n-2);

    }
    static int fibMemory(int n){
        int a[]=new int[n];
        a[0]=1;
        a[1]=1;
        for (int i = 2; i < n; i++) {
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }
    static int fibDP(int n){
        int a =1;
        int b =1;
        int c=0;
        for (int i = 2; i < n; i++) {
            c=a+b;
            a=b;
            b=c;

        }
        return c;
    }
}
