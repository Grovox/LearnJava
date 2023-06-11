package DynamicProgramming.Bunny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());

        double[] dp = new double[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= K; i ++){
            dp[i] = dp[i - 1] * 2;
            System.out.println(i + " q1 " + dp[i]);
        }
        for (int i = K + 1; i <= N; i++){
            dp[i] = dp[i - 1] * 2 - dp[i - K - 1];
            System.out.println(i +" q2 " + dp[i]);
        }

        System.out.println(dp[N]);

    }
}
