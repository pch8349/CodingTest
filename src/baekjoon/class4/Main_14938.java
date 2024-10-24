package baekjoon.class4;

import java.io.*;
import java.util.*;
public class Main_14938 {
    static int n, m, r;
    static int []item;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[n+1][n+1];
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<n+1; j++) map[i][j] = 30;
            map[i][i] = 0;
        }
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        floydWarshall();

        int ans = 0;
        for(int i = 1; i<=n; i++){
            int maxV = 0;
            for(int j = 1; j<=n; j++){
                if(map[i][j]<=m) {
                    maxV += item[j];
                }
            }
            ans = Math.max(ans, maxV);
        }
        System.out.println(ans);
    }

    static void floydWarshall(){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    if(map[j][k] > map[j][i]+map[i][k]){
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }
    }
}