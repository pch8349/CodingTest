package baekjoon.silver;
import java.io.*;
public class Main_2156 {
    static int N;
    static int []wine;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        wine = new int[N];
        dp = new int[N][2];

        for(int i = 0; i<N; i++) wine[i] = Integer.parseInt(br.readLine());

        dp[0][0] = wine[0];
        int maxNum = 0;
        if(N>1) {
            dp[1][0] = wine[0] + wine[1];
            dp[1][1] = wine[1];

            for(int i = 2; i<N; i++){
                maxNum = Math.max(maxNum, Math.max(dp[i-2][0], dp[i-2][1]));
                dp[i][0] = dp[i-1][1] + wine[i];
                dp[i][1] = maxNum + wine[i];
            }
        }

        maxNum = Math.max(maxNum,Math.max(dp[N-1][0], dp[N-1][1]));
        if(N>1) maxNum = Math.max(maxNum,Math.max(dp[N-2][0], dp[N-2][1]));

        bw.write(String.valueOf(maxNum));
        bw.flush();
        bw.close();
    }
}