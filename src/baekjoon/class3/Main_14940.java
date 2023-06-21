package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_14940 {
    static int N;
    static int M;
    static int arr[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int st_x = 0;
        int st_y = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) - 1;
                if(arr[i][j] == 1) {
                    st_x = i;
                    st_y = j;
                }
            }
        }

        int mv[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean visit[][] = new boolean[N][M];
        visit[st_x][st_y] = true;
        arr[st_x][st_y] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{st_x, st_y});
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.poll()[1];
            for(int i = 0; i<4; i++){
                int a = x + mv[i][0];
                int b = y + mv[i][1];
                if(a<0||b<0||a>=N||b>=M||visit[a][b]||arr[a][b] != 0) continue;
                q.add(new int[]{a, b});
                visit[a][b] = true;
                arr[a][b] = arr[x][y] + 1;
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(arr[i][j] == -1) arr[i][j] = 0;
                else if(arr[i][j] == 0) arr[i][j] = -1;
            }
        }
        arr[st_x][st_y] = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
