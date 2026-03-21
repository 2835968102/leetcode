package graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 433. 最小基因变化
 * https://leetcode.cn/problems/minimum-genetic-mutation/
 *
 * BFS 广度优先搜索
 * - 每次改变一个字符，找到与当前基因变化为1的基因入队
 * - 层次遍历保证第一次找到就是最小变化次数
 *
 * Time: O(n * 8), n 是基因库长度，每次需要检查所有基因是否差1个字符
 * Space: O(n), 队列最多存储所有基因
 */
public class _433_MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length < 1 || !endInBank(endGene, bank)) {
            return -1;
        }

        Deque<String> que = new LinkedList<String>();
        int minChangeNum = 0;
        que.offer(startGene);

        while (!que.isEmpty()) {
            int size = que.size();
            minChangeNum++;
            while (size > 0) {
                String cur = que.poll();
                if (minChangeNum > bank.length) {
                    return -1;
                }
                if (isMinChange(cur, endGene)) {
                    return minChangeNum;
                }
                for (String next : bank) {
                    if (isMinChange(cur, next)) {
                        que.offer(next);
                    }
                }
                size--;
            }
        }

        return -1;
    }

    public boolean isMinChange(String s1, String s2) {
        int change = 0;
        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                change++;
            }
        }

        if (change == 1) return true;
        return false;
    }

    public boolean endInBank(String end, String[] bank) {
        for (String cur : bank) {
            if (end.equals(cur)) {
                return true;
            }
        }
        return false;
    }
}
