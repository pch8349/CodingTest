package baekjoon.silver;
import java.io.*;
public class Main_2579 {
    static int N;
    static int []stairs;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        for(int i = 0; i<N; i++) stairs[i] = Integer.parseInt(br.readLine());

        dp = new int[N][2];
        dp[0][0] = stairs[0];
        if(N>1){
            dp[1][0] = stairs[0]+stairs[1];
            dp[1][1] = stairs[1];
            for (int i = 2; i < N; i++) {
                dp[i][0] = dp[i - 1][1] + stairs[i];

                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
            }
        }

        int ans = Math.max(dp[N-1][0], dp[N-1][1]);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}