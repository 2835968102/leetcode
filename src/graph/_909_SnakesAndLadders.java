package graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
public class _909_SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        Deque<Integer> que = new LinkedList<Integer>();
        HashSet<Integer> map = new HashSet<Integer>();
        que.offer(1);
        map.add(1);
        int gameNum = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            gameNum++;
            while (size > 0) {
                Integer cur = que.poll();
                size--;
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    int[] rc = new int[2];
                    rc = cacuBoard(next, board.length);
                    int target = board[rc[0]][rc[1]];
                    if (target != -1) {
                        next = target;
                    }
                    if (!map.contains(next)) {
                        if (next == board.length * board.length) {
                            return gameNum;
                        }
                        map.add(next);
                        que.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public int[] cacuBoard(int cur, int len) {
        int layer = (cur - 1) / len + 1;
        int rest = (cur - 1) % len;

        int x = len - layer;
        int y;
        if (layer % 2 == 0) {
            y = len - rest - 1;
        } else {
            y = rest;
        }

        return new int[]{x, y};
    }
}
