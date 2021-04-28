// https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1
package graphNtrees;

public class XShape {
    public int xShape(char[][] grid)
    {
        // code here
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 'X') {
                    count ++ ;
                    grid = fillNeighbours(grid, 0, 0);
                }
            }
        }
        return count;
    }

    private char[][] fillNeighbours(char[][] grid, int i, int j) {
        int rows = grid.length;
        int col = grid[0].length;

        if(i < rows && j < col && grid[i][j] == 'X'){
            grid[i][j] = 'O';
            fillNeighbours(grid,i+1,j);
            fillNeighbours(grid,i-1,j);
            fillNeighbours(grid,i,j+1);
            fillNeighbours(grid,i,j-1);
        }
        return grid;
    }
}
