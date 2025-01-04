package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1149 {
    static int N;
    static int [][]rgb;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        rgb = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + rgb[i][j];
            }
        }

        int ans = Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1]));

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
