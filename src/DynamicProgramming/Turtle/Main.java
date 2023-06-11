package DynamicProgramming.Turtle;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bufferSize = reader.readLine().split(" ");
        int N = Integer.valueOf(bufferSize[0]);
        int M = Integer.valueOf(bufferSize[1]);
        int[][] a = new int[N][M];

        String[] bufferMatrix = new String[M];
        for (int i = 0; i < N; i++){
            bufferMatrix = reader.readLine().split(" ");
            for (int j = 0; j < M; j++){
                a[i][j] = Integer.valueOf(bufferMatrix[j]);
            }
        }

        String[][] dpTrek = new String[N][M];
        dpTrek[0][0] = "";
        int[][] dp = new int[N][M];
        dp[0][0] = a[0][0];
        for (int i = 0; i < N; i++){
            if(i > 0){
                dp[i][0] = dp[i - 1][0] + a[i][0];
                dpTrek[i][0] = dpTrek[i - 1][0] + "D ";
            }
            for (int j = 1; j < M; j++){
                dp[0][j] = dp[0][j - 1] + a[0][j];
                dpTrek[0][j] =  dpTrek[0][j - 1] +  "R ";
            }
        }
        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                if(dp[i - 1][j] > dp[i][j - 1]){
                    dp[i][j] = dp[i - 1][j] + a[i][j];
                    dpTrek[i][j] = dpTrek[i - 1][j] +  "D ";
                }else {
                    dp[i][j] = dp[i][j - 1] + a[i][j];
                    dpTrek[i][j] = dpTrek[i][j - 1] +  "R ";
                }
            }
        }
        dpTrek[N - 1][M - 1] = dpTrek[N - 1][M - 1].trim();

        writer.write(String.valueOf(dp[N - 1][M - 1]));
        writer.newLine();
        writer.write(String.valueOf(dpTrek[N - 1][M - 1]));

        reader.close();
        writer.close();
    }
}
