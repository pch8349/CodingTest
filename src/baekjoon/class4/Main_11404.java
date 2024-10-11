package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_11404 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int route[][] = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            Arrays.fill(route[i], Integer.MAX_VALUE);
            route[i][i] = 0;
        }
        for(int i = 0; i<m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            route[start][end] = Math.min(cost, route[start][end]);
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n ;k++){
                    if(route[j][i] != Integer.MAX_VALUE && route[i][k] != Integer.MAX_VALUE) {
                        route[j][k] = Math.min(route[j][i] + route[i][k], route[j][k]);
                    }
                }
            }
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(route[i][j] == Integer.MAX_VALUE) System.out.print(0+" ");
                else System.out.print(route[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
