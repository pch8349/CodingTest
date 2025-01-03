package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1904 {
    static int N;
    static int dp[] = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=N; i++){
            dp[i] = (dp[i-1]+dp[i-2])%15746;
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}
