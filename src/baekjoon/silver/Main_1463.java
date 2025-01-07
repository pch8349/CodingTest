package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1463 {
    static int N;
    static int []dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        for(int i = N; i>0; i--){
            if(i%3 == 0){
                dp[i/3] = Math.min(dp[i]+1, dp[i/3]);
            }
            if(i%2 == 0){
                dp[i/2] = Math.min(dp[i]+1, dp[i/2]);
            }
            dp[i-1] = Math.min(dp[i]+1, dp[i-1]);
        }

        bw.write(String.valueOf(dp[1]));
        bw.flush();
        bw.close();
    }
}