import java.util.Scanner;

// 注意类名必须�?Main, 不要有任�?package xxx 信息
public class XiaoMeiMT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            int count = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == 'M' || ch == 'T') {
                    count++;
                }
            }

            System.out.println(Math.min(n, count + k));
        }
    }
}
