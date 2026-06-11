import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int q = in.nextInt();

            long sum = 0;
            long zeroCount = 0;
            for (int i = 0; i < n; i++) {
                long num = in.nextLong();
                if (num == 0) {
                    zeroCount++;
                } else {
                    sum += num;
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < q; i++) {
                long l = in.nextLong();
                long r = in.nextLong();
                ans.append(sum + zeroCount * l)
                        .append(' ')
                        .append(sum + zeroCount * r)
                        .append('\n');
            }

            System.out.print(ans);
        }
    }
}
