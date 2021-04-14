//https://www.youtube.com/watch?v=S3rnLLHl0PM&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s&index=59
public class ShortestPathMaze {
    public static void main(String[] args) {
        int maze[][] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        int result=shortestPath(maze, 0,0,3,4,new boolean[maze.length][maze[0].length]);
        if(result >= 10000)
            System.out.printf("No Path Possible");
        else
            System.out.println(result);
            }

    static boolean isValid(int a[][],int i,int j,boolean visited[][]){
        int rows=a.length;
        int cols=a[0].length;

        return (i >= 0 && j >= 0 && i < rows && j < cols && a[i][j] == 1 && !visited[i][j]);
    }
    static int shortestPath(int a[][],int i,int j,int x,int y,boolean visited[][])
    {
        if(!isValid(a,i,j,visited))
            return 10000;
        if(x == i && y == j)
            return 0;

        visited[i][j]=true;
        int left=shortestPath(a,i,j-1,x,y,visited)+1;
        int right=shortestPath(a,i,j+1,x,y,visited)+1;
        int top=shortestPath(a,i-1,j,x,y,visited)+1;
        int bottom=shortestPath(a,i+1,j,x,y,visited)+1;

        //backtracking
        visited[i][j]=false;

        return Math.min(Math.min(left,right),Math.min(top,bottom));
    }
}
