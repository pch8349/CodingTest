package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_2565 {
    static int N;
    static int [][]wire;
    static int []dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        wire = new int[N][2];
        dp = new int[N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, (o1, o2) -> o1[0]-o2[0]);

        dp[0] = 1;
        for(int i = 1; i<N; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(wire[i][1] > wire[j][1]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 0;
        for(int i : dp){
            ans = Math.max(ans, i);
        }
        ans = N - ans;
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}