package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_2616 {
    static int N;
    static int [] seats;
    static int carry;
    static int []accumulateSum;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        seats = new int[N+1];
        accumulateSum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) {
            seats[i] = Integer.parseInt(st.nextToken());
            accumulateSum[i] = seats[i] + accumulateSum[i-1];
        }

        carry = Integer.parseInt(br.readLine());
        dp = new int[4][N+1];

        for(int i = 1; i<4; i++){
            for(int j = i*carry; j<=N; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-carry] + accumulateSum[j]-accumulateSum[j-carry]);
            }
        }

        bw.write(String.valueOf(dp[3][N]));
        bw.flush();
        bw.close();
    }
}
