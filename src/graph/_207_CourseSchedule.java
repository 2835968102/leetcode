package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * https://leetcode.cn/problems/course-schedule/
 *
 * 思路：DFS 拓扑排序，检测有向图中是否存在环
 * - 建立邻接表，visited 数组标记每个节点的状态：
 *   0 = 未访问，1 = 访问中（在当前 DFS 路径上），2 = 已完成
 * - DFS 过程中若遇到状态为 1 的节点，说明存在环，无法完成所有课程
 * - 所有节点 DFS 完成后无环，则返回 true
 *
 * Time: O(V+E), V 为课程数，E 为先决条件数
 * Space: O(V+E), 邻接表 + visited 数组 + 递归栈
 */
public class _207_CourseSchedule {

    // 写法一：在 DFS 中提前判断剪枝
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}

// 写法二：另一种 DFS 实现
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valide = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for(int[] v : prerequisites) {
            edges.get(v[1]).add(v[0]);
        }

        for(int i = 0; i < numCourses && valide; i++) {
            dfs(i);
            if(!valide) return false;
        }
        return valide;
    }

    public void dfs(int u) {
        if(visited[u] == 0) {
            visited[u] = 1;
            for(Integer v : edges.get(u)) {
                dfs(v);
            }
            visited[u] = 2;
        }

        if(visited[u] == 1) {
            valide = false;
            return;
        }
    }
}
