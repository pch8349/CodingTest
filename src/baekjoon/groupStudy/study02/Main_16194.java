package baekjoon.groupStudy.study02;

import java.io.*;
import java.util.*;
public class Main_16194 {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j]+arr[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
