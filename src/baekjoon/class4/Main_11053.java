package baekjoon.class4;

import java.io.*;
import java.util.*;
public class Main_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        int []dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int ans = 0;

        for(int i = 0; i<N; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]) {
                    dp[i]= Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

}
