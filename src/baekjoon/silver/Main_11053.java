package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_11053 {
    static int N;
    static int []series;
    static int []dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        series = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) series[i] = Integer.parseInt(st.nextToken());

        int ans = 1;
        dp[0] = 1;
        for(int i = 1; i<N; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(series[j] < series[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}