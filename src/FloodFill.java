//https://www.youtube.com/watch?v=JMxl5rk7kGo&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=58
public class FloodFill {
    public static void main(String[] args) {
        int a[][]={{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        floodfill(a,0,0,3,1);
        Print.print2DArray(a);
    }

    public static void floodfill(int a[][],int r,int c,int toFill,int prevFill){
        int rows=a.length;
        int cols=a[0].length;

        if(r<0||c<0||r>=rows||c>=cols)
            return;
        if(a[r][c]!=prevFill)
            return;
        a[r][c]=toFill;

        floodfill(a,r-1,c,toFill,prevFill);
        floodfill(a,r+1,c,toFill,prevFill);
        floodfill(a,r,c+1,toFill,prevFill);
        floodfill(a,r,c-1,toFill,prevFill);

    }
}
