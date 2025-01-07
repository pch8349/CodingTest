package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1932 {
    static int N;
    static int [][]triangle;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        triangle = new int[N][1001];
        dp = new int[N][1001];
        for(int i = 0; i<N; i++) Arrays.fill(triangle[i], -1);

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 500-i; j<=500+i; j+=2){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][500] = triangle[0][500];
        for(int i = 1; i<N; i++){
            for(int j = 500-i; j<=500+i; j+=2) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j+1]);
            }
        }

        int ans = 0;
        for(int i = 0; i<1001; i++) ans = Math.max(dp[N-1][i], ans);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}