package baekjoon.silver;

import java.io.*;
import java.util.*;
public class Main_11051 {
    static int N, K;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        arr[0][0] = 1; arr[1][0] = 1; arr[1][1] = 1;

        System.out.println(dp(N, K));
    }

    static int dp(int n, int k){
        if(arr[n][k] != 0) return arr[n][k];
        if(k>n) return 0;
        else if(k==0) return arr[n][k] = dp(n-1, k);
        else return arr[n][k] = (dp(n-1, k) + dp(n-1, k-1))%10007;
    }
}
