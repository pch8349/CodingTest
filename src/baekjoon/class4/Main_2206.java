package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_2206 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mv[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N][M];

        for(int i = 0; i<N; i++){
            String S = br.readLine();
            for(int j = 0; j<M; j++){
                map[i][j] = S.charAt(j) - '0';
            }
        }


        int weight[][][] = new int[2][N][M];
        // 가중치 배열 초기화
        for(int j = 0; j<N; j++) {
            Arrays.fill(weight[0][j], Integer.MAX_VALUE); // 안뚫
            Arrays.fill(weight[1][j], Integer.MAX_VALUE); // 뚫
        }
        weight[1][0][0] = 1;
        weight[0][0][0] = 1;

        int ans = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0}); // 0.x, 1.y, 2.weight, 3.0이면안뚫 1이면뚫

        while(!queue.isEmpty()){

            int arr[] = queue.poll();

            for(int i = 0; i<4; i++){

                int xNext = arr[0] + mv[i][0];
                int yNext = arr[1] + mv[i][1];

                // 배열 범위 밖이면 건너뜀
                if(xNext<0 || yNext<0 || xNext>=N || yNext>=M) continue;

                // 길일때
                if(map[xNext][yNext] == 0) {

                    // 벽안뚫 -> 벽안뚫
                    if(arr[3] == 0 && weight[0][xNext][yNext] > arr[2] + 1) {
                        weight[0][xNext][yNext] = arr[2] + 1;
                        queue.add(new int[]{xNext, yNext, arr[2]+1, 0});
                    }

                    // 벽안뚫 -> 벽뚫
                    if(arr[3] == 0 && weight[1][xNext][yNext] > arr[2] + 1){
                        weight[1][xNext][yNext] = arr[2] + 1;
                    }

                    // 벽뚫 -> 벽뚫
                    if(arr[3] == 1 && weight[1][xNext][yNext] > arr[2] + 1){
                        weight[1][xNext][yNext] = arr[2] + 1;
                        queue.add(new int[]{xNext, yNext, arr[2]+1, 1});
                    }
                }

                // 벽일때
                if(map[xNext][yNext] == 1) {

                    // 벽안뚫 -> 벽뚫
                    if(arr[3] == 0 && weight[1][xNext][yNext] > arr[2] + 1){
                        weight[1][xNext][yNext] = arr[2] + 1;
                        queue.add(new int[]{xNext, yNext, arr[2]+1, 1});
                    }

                }

            }
        }

        ans = Math.min(weight[0][N-1][M-1], weight[1][N-1][M-1]);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}