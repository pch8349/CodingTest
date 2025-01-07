package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_10844 {
    static int N;
    static int [][]dp;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[101][10];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i = 2; i<=N; i++){
            dp[i][0] = (dp[i][0] + dp[i-1][1]) % INF;
            for(int j = 1; j<9; j++){
                dp[i][j] = (dp[i][j] + dp[i-1][j-1] + dp[i-1][j+1]) % INF;
            }
            dp[i][9] = (dp[i][9] + dp[i-1][8]) % INF;
        }

        int ans = 0;
        for(int i = 0; i<10; i++) ans = (ans + dp[N][i])%INF;

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}