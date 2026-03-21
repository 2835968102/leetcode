package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 127. 单词接龙
 * https://leetcode.cn/problems/word-ladder/
 *
 * BFS 广度优先搜索
 * - 每次改变一个字符，找到与当前单词差1个字符且未访问过的单词入队
 * - 层次遍历保证第一次找到就是最短路径
 * - 使用 visited 数组标记已经访问过的单词，避免重复走
 *
 * Time: O(n * L), n 是单词表长度，L 是单词平均长度
 * Space: O(n), visited 数组 + 队列存储所有单词
 */
public class _127_WordLadder {

    int wordListSize;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordListSize = wordList.size();

        if (wordListSize < 1 || !endInBank(endWord, wordList)) {
            return 0;
        }

        Deque<String> que = new LinkedList<String>();
        int minChangeNum = 0;
        que.offer(beginWord);
        boolean[] visited = new boolean[wordListSize];

        while (!que.isEmpty()) {
            int size = que.size();
            minChangeNum++;
            while (size > 0) {
                String cur = que.poll();
                if (minChangeNum > wordListSize) {
                    return 0;
                }
                if (isMinChange(cur, endWord)) {
                    return minChangeNum + 1;
                }
                for (int i = 0; i < wordListSize; i++) {
                    if (visited[i] == true) continue;
                    String next = wordList.get(i);
                    if (isMinChange(cur, next)) {
                        que.offer(next);
                        visited[i] = true;
                    }
                }
                size--;
            }
        }

        return 0;
    }

    public boolean isMinChange(String s1, String s2) {
        int change = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                change++;
            }
        }
        return change == 1;
    }

    public boolean endInBank(String end, List<String> bank) {
        for (String cur : bank) {
            if (end.equals(cur)) {
                return true;
            }
        }
        return false;
    }
}
