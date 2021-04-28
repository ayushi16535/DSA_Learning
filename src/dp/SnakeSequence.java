// https://www.techiedelight.com/maximum-length-snake-sequence/ 
package dp;

import java.util.Arrays;

public class SnakeSequence {
    public static void main(String[] args) {
        int[][] grid =
                {
                        { 7, 5, 2, 3, 1 },
                        { 3, 4, 1, 4, 4 },
                        { 1, 5, 6, 7, 8 },
                        { 3, 4, 5, 8, 9 },
                        { 3, 2, 2, 7, 6 }
                };
        System.out.println("The length is " + maxSnakeLength(grid));
    }

    private static int maxSnakeLength(int[][] grid) {
        int max_so_far = 0;
        int row = grid.length;
        int col = grid[0].length;

        int L[][] = new int[row][col];

        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < col; j++) {
                if (i - 1 >= 0 && Math.abs(grid[i][j] - grid[i - 1][j]) == 1)
                {
                    L[i][j] = Math.max(L[i][j], 1 + L[i - 1][j]);
                    max_so_far = Math.max(L[i][j], max_so_far);
                }

                if(j - 1 >= 0 && Math.abs(grid[i][j] - grid[i][j-1]) == 1)
                {
                    L[i][j] = Math.max(L[i][j], 1 + L[i][j - 1]);
                    max_so_far = Math.max(L[i][j], max_so_far);
                }
            }
        }

        return max_so_far;
    }
}
