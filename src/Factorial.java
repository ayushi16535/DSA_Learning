public class Factorial {
    public static void main(String[] args) {
        fact(5);
        System.out.println(factRecursive(5));
    }

    private static int factRecursive(int n) {
        //breaking point
        if(n==1)
            return 1;
        return n*factRecursive(n-1);
    }

    private static void fact(int n) {
        int fact=1;
        for (int i = 1; i <=n; i++) {
            fact=fact*i;
        }
        System.out.println("Factorial of "+n+" = "+fact);
    }

}
