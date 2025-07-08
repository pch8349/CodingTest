package baekjoon.platinum;
import java.io.*;
import java.util.*;
public class Main_1028 {
    static int N, M;
    static int[][] arr;
    static int[][][] dp;
    static int[][] mv = {{1,-1}, {1,1}, {-1, -1}, {-1, 1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 0 : ↙️, 1 : ↘️, 2 : ↖️, 3 : ↗️
        dp = new int[4][N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                getDpLength(i, j, 2);
            }
        }
        for(int i=N-1; i>=0; i--){
            for(int j=M-1; j>=0; j--){
                getDpLength(i, j, 0);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int down = Math.min(dp[0][i][j], dp[1][i][j]);
                if(down <= ans) continue; // 지금까지의 최대값보다 작으면 굳이 안보기
                if(ans == 0) ans = 1;
                for(int k=ans; k<=down; k++){
                    int n = i+k+k-2;// 다이아의 아래 꼭지점 위치 파악
                    if(n>=N) continue; // 다이아의 아래 꼭지점이 배열 밖 나가면 던지기
                    int up = Math.min(dp[2][n][j], dp[3][n][j]);
                    if(k<=up) ans = Math.max(ans, k);
                }
            }
        }
        System.out.println(ans);
    }

    static void getDpLength(int a, int b, int K){
        if(arr[a][b] == 0) return;
        for(int k=K; k<K+2; k++){
            dp[k][a][b] = 1;
            int x = a+mv[k][0];
            int y = b+mv[k][1];
            if(x<0||y<0||x>=N||y>=M) continue;
            dp[k][a][b] = dp[k][x][y]+1;
        }
    }
}