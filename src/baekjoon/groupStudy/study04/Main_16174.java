package baekjoon.groupStudy.study04;
import java.io.*;
import java.util.*;
public class Main_16174 {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static String ans = "Hing";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int x, int y){
        System.out.println(x+" "+y);
        visit[x][y] = true;
        if(x == N-1 && y == N-1){
            ans = "HaruHaru";
            return;
        }
        for(int i = 0; i<2; i++){
            int nx = x + i*arr[x][y];
            int ny = y + (1-i) * arr[x][y];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])continue;
            dfs(nx, ny);
        }
    }
}