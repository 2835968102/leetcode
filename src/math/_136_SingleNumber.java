package math;

/**
 * 136. Single Number
 * https://leetcode.cn/problems/single-number/
 *
 * 利用异或运算：
 * 1) a ^ a = 0
 * 2) a ^ 0 = a
 * 3) 交换律和结合律
 * 数组中其余数都出现两次，只有一个数出现一次，异或后即得到该数。
 */
public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
