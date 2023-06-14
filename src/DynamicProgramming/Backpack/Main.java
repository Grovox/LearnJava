package DynamicProgramming.Backpack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++){
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            scanner.nextLine();
        }

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= W; i ++){
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i ++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= W; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= a[i - 1][0]){
                    dp[i][j] = Math.max(dp[i - 1][j - a[i - 1][0]] + a[i - 1][1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}
