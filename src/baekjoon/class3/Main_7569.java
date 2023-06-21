package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_7569 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int [][][]arr = new int[H][N][M];
        int ans = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int h = 0; h<H; h++){
            for(int n = 0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m<M; m++){
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if(arr[h][n][m] == 1){
                        q.add(new int[]{h, n, m, 0});
                    }
                }
            }
        }

        int mv[][] = {{1,0,0}, {-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

        while(!q.isEmpty()){
            int []now = q.poll();
            for(int i = 0; i<6; i++){
                int h = now[0]+mv[i][0];
                int n = now[1]+mv[i][1];
                int m = now[2]+mv[i][2];
                if(h<0||n<0||m<0||h>=H||n>=N||m>=M||arr[h][n][m]!=0) continue;
                arr[h][n][m] = 1;
                q.add(new int[]{h, n, m, now[3]+1});
                ans = Math.max(ans, now[3]+1);
            }
        }

        for(int h = 0; h<H; h++){
            for(int n = 0; n<N; n++){
                for(int m = 0; m<M; m++){
                    if(arr[h][n][m] == 0){
                        ans = -1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
