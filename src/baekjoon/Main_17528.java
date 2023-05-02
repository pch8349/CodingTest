package baekjoon;

import java.util.*;
import java.io.*;

public class Main_17528 {
    static int N;
    static int arr[][];
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int sum = 0;
        arr = new int[N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][0];
        }

        dp = new int[N][N*250];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N*250; j++) dp[i][j] = Integer.MAX_VALUE;
        }

        dp[0][sum] = 0;
        dp[0][sum - arr[0][0]] = arr[0][1];
        for(int i = 1; i<N; i++){
            for(int j = 1; j<N*250; j++){
                if(dp[i][j] != Integer.MAX_VALUE){
                    dp[i+1][j] = dp[i][j];
                    dp[i+1][j - arr[i+1][0]] = Math.min(dp[i+1][j - arr[i+1][0]], dp[i][j]+arr[i+1][1]);
                }
            }
        }

        sum = Integer.MAX_VALUE;
        for(int i = 0; i<N*250; i++) sum = Math.min(sum, Math.max(i, dp[N-1][i]));

        System.out.println(sum);
    }

}
