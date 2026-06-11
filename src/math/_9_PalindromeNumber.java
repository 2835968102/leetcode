package math;

/**
 * 9. Palindrome Number
 * https://leetcode.cn/problems/palindrome-number/
 */
public class _9_PalindromeNumber {

    public boolean isPalindromeByString1(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindromeByString2(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    // LeetCode 默认入口（与上面两种实现等价）
    public boolean isPalindrome(int x) {
        return isPalindromeByString1(x);
    }
}

