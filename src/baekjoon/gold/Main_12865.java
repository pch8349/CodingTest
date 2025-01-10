package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_12865 {
    static int N, K;
    static int [][]s; // 무게, 가치
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        s = new int[N+1][2];
        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1][K+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=s[i][0]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-s[i][0]] + s[i][1]);
                }
            }
        }


        int ans = dp[N][K];

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}