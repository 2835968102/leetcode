import java.util.Scanner;

// 注意类名必须�?Main, 不要有任�?package xxx 信息
public class XiaoMeiSubMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[][] pre = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                String row = in.next();
                for (int j = 1; j <= n; j++) {
                    int val = row.charAt(j - 1) - '0';
                    pre[i][j] = pre[i - 1][j]
                            + pre[i][j - 1]
                            - pre[i - 1][j - 1]
                            + val;
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int len = 1; len <= n; len++) {
                if (len % 2 == 1) {
                    ans.append(0).append('\n');
                    continue;
                }

                int count = 0;
                int target = len * len / 2;
                for (int i = 1; i + len - 1 <= n; i++) {
                    for (int j = 1; j + len - 1 <= n; j++) {
                        int x2 = i + len - 1;
                        int y2 = j + len - 1;
                        int ones = pre[x2][y2]
                                - pre[i - 1][y2]
                                - pre[x2][j - 1]
                                + pre[i - 1][j - 1];

                        if (ones == target) {
                            count++;
                        }
                    }
                }
                ans.append(count).append('\n');
            }

            System.out.print(ans);
        }
    }
}
