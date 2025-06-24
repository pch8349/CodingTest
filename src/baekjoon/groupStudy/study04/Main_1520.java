package baekjoon.groupStudy.study04;
import java.io.*;
import java.util.*;
public class Main_1520 {
    static int N, M;
    static int[][] arr;
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        int ans = dp(0, 0);

        System.out.println(ans);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++) {
                if(visit[i][j] >= 0) System.out.print(" ");
                System.out.print(visit[i][j]+" ");

            }
            System.out.println();
        }
    }

    static int dp(int x, int y){

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++) System.out.print(visit[i][j]+" ");
            System.out.println();
        }
        System.out.println("\n\n");

        int[][] mv = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if(x == N-1 && y == M-1) return 1; // 도착지
        if(visit[x][y] >-1) return visit[x][y]; // 이미 계산한 경우

        visit[x][y] = 0; // 현재 위치에서 시작하는 경로 수 누적 시작
        for(int[] i : mv){

            if(x+i[0]<0||y+i[1]<0||x+i[0]>=N||y+i[1]>=M || arr[x][y] <= arr[x+i[0]][y+i[1]]) continue;
            System.out.println((x+i[0])+","+(y+i[1]));
            visit[x][y] += dp(x+i[0], y+i[1]);
        }
        return visit[x][y];
    }
}