package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * https://leetcode.cn/problems/ipo/
 *
 * 思路：
 * 1. 将项目按启动资本 capital 从小到大排序。
 * 2. 每轮最多执行一个项目（共执行 k 次）：
 *    - 把所有当前资本 w 可启动的项目利润加入大顶堆；
 *    - 若堆为空则提前结束（后续无法做更多项目）；
 *    - 从堆中取最大利润，累加到 w。
 *
 * 时间复杂度：O(n log n + k log n)
 * 空间复杂度：O(n)
 */
public class _502_IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;

        for (int i = 0; i < k; i++) {
            while (index < n && projects[index][0] <= w) {
                maxHeap.offer(projects[index][1]);
                index++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }
}
