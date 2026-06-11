package math;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 */
public class _172_FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;

        while (n > 0) {
            n /= 5;
            ans += n;
        }

        return ans;
    }
}

