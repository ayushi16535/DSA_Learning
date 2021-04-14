//https://www.youtube.com/watch?v=AqHoXqOgctU&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=56
public class Path {
    public static void main(String[] args) {
        System.out.println(path(3,3));
    }

    private static int path(int m, int n) {
        if(m==1 ||n==1)
            return 1;
        return path(m,n-1)+path(m-1,n);
    }
}
