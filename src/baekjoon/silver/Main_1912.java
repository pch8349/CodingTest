package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1912 {
    static int N;
    static int []arr;
    static int []dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int ans = dp[0];
        for(int i = 1; i<N; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            ans = Math.max(ans, dp[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
