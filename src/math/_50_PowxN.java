package math;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 */
public class _50_PowxN {
    public double myPow(double x, int n) {
        long N = n; // 防止 Integer.MIN_VALUE 溢出

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1.0;

        while (N > 0) {
            if ((N & 1) == 1) { // 当前二进制位是1
                ans *= x;
            }

            x *= x;  // 底数平方
            N >>= 1; // 指数除2
        }

        return ans;
    }
}

