package baekjoon;

import java.io.*;
import java.util.*;

public class Main_21923 {
    static int N;
    static int M;
    static int [][]map;
    static int [][]upCost;
    static int [][]downCost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        upCost = new int[N][M];
        downCost = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //올라가는 과정
        upCost[N-1][0] = map[N-1][0];
        for(int i = N-2; i>=0; i--){
            upCost[i][0] = upCost[i+1][0] + map[i][0];
        }
        for(int j = 1; j<M; j++){
            upCost[N-1][j] = upCost[N-1][j-1] + map[N-1][j];
        }
        for(int i = N-2; i>=0; i--) {
            for(int j = 1; j<M; j++){
                upCost[i][j] = Math.max(upCost[i+1][j], upCost[i][j-1]) + map[i][j];
            }
        }

        //내려가는 과정
        downCost[N-1][M-1] = map[N-1][M-1];
        for(int i = N-2; i>=0; i--) {
            downCost[i][M-1] = downCost[i+1][M-1] + map[i][M-1];
        }
        for(int i = M-2; i>=0; i--) {
            downCost[N-1][i] = downCost[N-1][i+1] + map[N-1][i];
        }
        for(int i = N-2; i>=0; i--) {
            for(int j = M-2; j>=0; j--) {
                downCost[i][j] = Math.max(downCost[i+1][j], downCost[i][j+1]) + map[i][j];
            }
        }

        int maxn = -999999999;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                maxn = Math.max(maxn, (upCost[i][j]+downCost[i][j]));
            }
        }
        System.out.println(maxn);
    }
}
