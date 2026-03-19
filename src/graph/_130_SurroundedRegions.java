package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 * https://leetcode.cn/problems/surrounded-regions/
 *
 * 解法一：从边界出发 DFS，标记所有不会被围绕的 'O'
 * - 与边界相连的 'O' 不会被围绕，先用 DFS 标记为 'A'
 * - 遍历边界的四条边，对每个 'O' 进行 DFS
 * - 最后遍历整个棋盘：'A' 恢复为 'O'，'O' 变为 'X'
 *
 * Time: O(mn), 每个格子最多被访问一次
 * Space: O(mn), 最坏情况递归深度为 mn
 */
public class _130_SurroundedRegions {

    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

/**
 * 解法二：从边界出发 BFS，标记所有不会被围绕的 'O'
 * - 将边界上的所有 'O' 加入队列，标记为 'A'
 * - BFS 扩展所有与边界相连的 'O'，全部标记为 'A'
 * - 最后遍历整个棋盘：'A' 恢复为 'O'，'O' 变为 'X'
 *
 * Time: O(mn), 每个格子最多被访问一次
 * Space: O(mn), 队列最多存储 mn 个元素
 */
class _130_SurroundedRegions_BFS {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'A';
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new int[]{m - 1, i});
                board[m - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= m || my >= n || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
