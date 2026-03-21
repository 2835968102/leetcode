package array;

public class _3643_ReverseSubmatrix {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                int mid = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + (k - i - 1)][y + j];
                grid[x + (k - i - 1)][y + j] = mid;
            }
        }

        return grid;
    }
}
