package backtracking;

import java.util.HashSet;
import java.util.Set;

public class _52_NQueensII {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int totalNQueensByColumn(int n) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrackByColumn(n, 0, rows, diagonals1, diagonals2);
    }

    public int totalNQueensBitmask(int n) {
        return solveBitmask(n, 0, 0, 0, 0);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (columns.contains(col)) {
                continue;
            }

            int diagonal1 = row - col;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }

            int diagonal2 = row + col;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }

            columns.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
            columns.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
        return count;
    }

    public int backtrackByColumn(int n, int column, Set<Integer> rows, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (column == n) {
            return 1;
        }

        int count = 0;
        for (int row = 0; row < n; row++) {
            if (rows.contains(row)) {
                continue;
            }

            int diagonal1 = row + column;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }

            int diagonal2 = column - row;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }

            rows.add(row);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            count += backtrackByColumn(n, column + 1, rows, diagonals1, diagonals2);
            rows.remove(row);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
        return count;
    }

    public int solveBitmask(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions - 1);
            count += solveBitmask(
                    n,
                    row + 1,
                    columns | position,
                    (diagonals1 | position) << 1,
                    (diagonals2 | position) >> 1
            );
        }
        return count;
    }
}
