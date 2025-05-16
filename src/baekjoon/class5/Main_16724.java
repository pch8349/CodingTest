package baekjoon.class5;

import java.io.*;
import java.util.*;

public class Main_16724 {

    static int N, M;
    static int count = 0;
    static char[][] arr;
    static int[][] group;
    static Map<Character, int[]> mv = Map.of(
            'D', new int[]{1, 0}, 'U', new int[]{-1, 0}, 'L', new int[]{0, -1}, 'R', new int[]{0, 1}
    );

    public static void dfs(int x, int y, int id){
        int mx = x + mv.get(arr[x][y])[0];
        int my = y + mv.get(arr[x][y])[1];

        group[x][y] = id; // 방문중임을 표시

        if(group[mx][my] == 0){
            dfs(mx, my, id);
        } else if(group[x][y] == group[mx][my]){
            group[x][y] = id;
            count++;
        } else {
            group[x][y] = group[mx][my];
        }
        group[x][y] = group[mx][my];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        group = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken().toCharArray();
        }

        int id = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (group[i][j] == 0) {
                    dfs(i, j, id++);
                }
            }
        }

        System.out.println(count);

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//    }
    }
}