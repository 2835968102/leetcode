package array;

/**
 * 74. 搜索二维矩阵
 * https://leetcode.cn/problems/search-a-2d-matrix/
 *
 * 思路：一维展开 + 二分查找
 * - 将 m x n 矩阵看成长度为 m * n 的有序数组
 * - 一维下标 index 对应矩阵位置 matrix[index / n][index % n]
 * - 对一维下标范围 [0, m * n - 1] 进行二分搜索
 *
 * 时间复杂度：O(log(mn))
 * 空间复杂度：O(1)
 */
public class _74_SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int row = mid / n;
            int col = mid % n;
            int num = matrix[row][col];

            if (num == target) {
                return true;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
