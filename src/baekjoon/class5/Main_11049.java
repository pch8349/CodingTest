package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_11049 {

    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int len = 2; len <= N; len++){
            for(int i = 0; i<=N - len; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k< j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (long) arr[i][0] * arr[k][1] * arr[j][1]);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}