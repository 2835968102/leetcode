package math;

/**
 * 191. Number of 1 Bits
 * https://leetcode.cn/problems/number-of-1-bits/
 *
 * 利用 n & (n - 1) 每次去掉最低位的 1。
 */
public class _191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
