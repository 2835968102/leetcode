package graph;

/**
 * 200. 岛屿数量
 * https://leetcode.cn/problems/number-of-islands/
 *
 * 思路：深度优先搜索（DFS）沉没海岛
 * - 遍历网格每一个格子，如果是 '1' 说明发现新岛屿
 * - 使用 DFS 把这个岛屿相连的所有 '1' 都标记为 '0'（沉没）
 * - 每发现一个新岛屿，计数器加 1
 *
 * Time: O(mn), 每个格子最多被访问一次
 * Space: O(mn), 最坏情况整个网格都是岛屿，递归深度就是 mn
 */
public class _200_NumberOfIslands {

    public void dfs(char[][] grid, int r, int c) {
        int rn = grid.length;
        int cn = grid[0].length;

        if (r < rn && c < cn && r >= 0 && c >= 0 && grid[r][c] == '1') {
            grid[r][c] = '0';
        } else {
            return;
        }
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int island = 0;
        int rn = grid.length;
        int cn = grid[0].length;
        for (int r = 0; r < rn; ++r) {
            for (int c = 0; c < cn; ++c) {
                if (grid[r][c] == '1') {
                    island++;
                    dfs(grid, r, c);
                }
            }
        }
        return island;
    }
}
