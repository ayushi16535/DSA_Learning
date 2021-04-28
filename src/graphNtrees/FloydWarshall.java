// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
package graphNtrees;

public class FloydWarshall {
    public void shortest_distance(int[][] matrix) {
        // Code here
        int v = matrix.length;
        if (v > 2) {
            for (int k = 0; k < v; k++) {
                for (int i = 0; i < v; i++) {
                    for (int j = 0; j < v; j++) {
                        if (i == j || i == k || j == k)
                            continue;
                        else if (matrix[i][k] != -1 && matrix[k][i] != -1)
                        {
                            if (matrix[i][j] == -1 || matrix[i][j] > matrix[i][k] + matrix[k][j])
                                matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }
        }
    }
}
