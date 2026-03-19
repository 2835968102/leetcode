package graph;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 210. 课程表 II
 * https://leetcode.cn/problems/course-schedule-ii/
 *
 * 思路：DFS 拓扑排序，返回拓扑排序结果
 */
public class _210_CourseScheduleII {

    // 写法一：修正后的 DFS 解法
    static class Solution1 {
        List<List<Integer>> mid;
        int[] visited;
        boolean valid;
        Deque<Integer> stack;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            mid = new ArrayList<List<Integer>>();
            visited = new int[numCourses];
            valid = true;
            stack = new ArrayDeque<Integer>();
            for(int i = 0; i < numCourses; i++) {
                mid.add(new ArrayList<Integer>());
            }

            for(int[] u : prerequisites) {
                mid.get(u[1]).add(u[0]);
            }

            for(int i = 0; i < numCourses && valid; i++) {
                if(visited[i] == 0) {
                    dfs(i);
                }
                if(!valid) break;
            }

            int[] ans = new int[numCourses];
            if(valid) {
                for(int i = 0; i < numCourses; i++) {
                    if(!stack.isEmpty()) {
                        ans[i] = stack.pop();
                    }
                }
                return ans;
            }

            return new int[0];
        }

        public void dfs(int u) {
            if(visited[u] == 0) {
                visited[u] = 1;
                for(int v : mid.get(u)) {
                    dfs(v);
                }
                visited[u] = 2;
                stack.push(u);
            }
            if(visited[u] == 1) {
                valid = false;
                return;
            }
        }
    }

    // 写法二：官方题解（正确）
    static class Solution2 {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid = true;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<Integer>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            index = numCourses - 1;
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }
            // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            if (!valid) {
                return new int[0];
            }
            // 如果没有环，那么就有拓扑排序
            return result;
        }

        public void dfs(int u) {
            // 将节点标记为「搜索中」
            visited[u] = 1;
            // 搜索其相邻节点
            // 只要发现有环，立刻停止搜索
            for (int v : edges.get(u)) {
                // 如果「未搜索」那么搜索相邻节点
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                }
                // 如果「搜索中」说明找到了环
                else if (visited[v] == 1) {
                    valid = false;
                    return;
                }
            }
            // 将节点标记为「已完成」
            visited[u] = 2;
            // 将节点入栈
            result[index--] = u;
        }
    }
}
