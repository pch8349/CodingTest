package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_17404 {
    static int N;
    static int [][] rgbArr;
    static int [][] dp;
    static final int INF = 1000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rgbArr = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++) rgbArr[i][j] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] 는 1~i-1 번째 집까지 칠하고, i번째 집을 j로 칠했을 때의 최소비용을 말한다.
        // 첫 집 색이 R 이면 G, B dp 값을 무한대, G 이면 R,B 의 dp 값을 무한대... 로 설정한다.
        dp = new int[N][3];

        // 첫 집의 색을 R, G, B 로 칠했을 때 각각의 경우에서 최소값을 구해 dp 배열에 채워주기
        // 그 후 마지막 집을 칠했을 때 첫 집의 색과 다른 마지막 집의 값들에서 최소값 추출하기

        int ans = INF;
        // k = R, G, B 로 첫 집 칠하는 경우의 수
        for(int k = 0; k < 3; k++){
            // 첫 집 색이 정해졌을 때, 나머지 첫 집 색을 INF 로 초기화
            for(int i = 0; i < 3; i++){
                if(i == k) dp[0][i] = rgbArr[0][i];
                else dp[0][i] = INF;
            }

            for(int i = 1; i < N; i++){
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgbArr[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgbArr[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgbArr[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(i != k) ans = Math.min(ans, dp[N - 1][i]);
            }
        }
        System.out.println(ans);
    }
}