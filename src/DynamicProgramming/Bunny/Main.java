package DynamicProgramming.Bunny;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int K = Integer.parseInt(scanner.nextLine());

        double[] dp = new double[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        int step = 1;
        for(int i = 2; i <= N; i ++){
            for(int j = step; j < i; j++){
                dp[i] += dp[j];
            }
            if(i > K){
                step ++;
            }
        }

        System.out.println(dp[N]);

    }
}
