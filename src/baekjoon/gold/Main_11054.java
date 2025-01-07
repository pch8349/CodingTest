package baekjoon.gold;
import java.io.*;
import java.util.*;

public class Main_11054 {
    static int N;
    static int []arr;
    static int []dp;
    static int []re_dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++)arr[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];
        dp[0] = 1;
        for(int i = 1; i<N; i++){
            dp[i] = 1;
           for(int j = 0; j<i; j++){
               if(arr[i] > arr[j]) dp[i] = Math.max(dp[j]+1, dp[i]);
           }
        }

        re_dp = new int[N];
        re_dp[N-1] = 1;
        for(int i = N-2; i>=0; i--){
            re_dp[i] = 1;
            for(int j = N-1; j>i; j--){
                if(arr[i]>arr[j]) re_dp[i] = Math.max(re_dp[j]+1, re_dp[i]);
            }
        }

        for(int i = 0; i<N; i++){
            ans = Math.max(ans, dp[i]+re_dp[i]-1);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
