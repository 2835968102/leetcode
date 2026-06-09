package string;

/**
 * 190. Reverse Bits
 * https://leetcode.cn/problems/reverse-bits/
 *
 * 时间复杂度：O(32) ≈ O(1)
 * 空间复杂度：O(1)
 */
public class _190_ReverseBits {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // res 左移一位，给新 bit 腾位置
            res <<= 1;

            // 取 n 的最低位，加到 res 最右边
            res |= (n & 1);

            // n 无符号右移一位
            n >>>= 1;
        }

        return res;
    }
}
