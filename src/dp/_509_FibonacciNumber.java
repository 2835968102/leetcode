package dp;

/**
 * 509. Fibonacci Number
 * https://leetcode.cn/problems/fibonacci-number/
 *
 * 思路：
 * 使用两个变量滚动记录 F(n - 2) 和 F(n - 1)，逐步推到 F(n)。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class _509_FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
