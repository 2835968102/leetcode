package binarysearch;

/**
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class _201_BitwiseAndOfNumbersRange {

    /**
     * 方案一：消去最低位（Brian Kernighan 思想）
     * 当 right 中有最低位1时，right &= right - 1 会清除该位，
     * 直到 left >= right 时剩余为共同前缀。
     */
    public int rangeBitwiseAnd_1(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }

    /**
     * 方案二：右移找公共前缀（对齐位数）
     * 同时右移 left/right，统计右移位数，最后再左移补零。
     */
    public int rangeBitwiseAnd_2(int left, int right) {
        int shift = 0;

        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    /**
     * 与 LeetCode 默认入口保持一致，返回其中一种写法。
     */
    public int rangeBitwiseAnd(int left, int right) {
        return rangeBitwiseAnd_2(left, right);
    }
}

