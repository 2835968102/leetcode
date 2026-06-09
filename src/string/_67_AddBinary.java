package string;

/**
 * 67. Add Binary
 * https://leetcode.cn/problems/add-binary/
 *
 * 时间复杂度：O(max(m, n))
 * 空间复杂度：O(max(m, n))
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = x + y + carry;
            res.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        return res.reverse().toString();
    }
}
