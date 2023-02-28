package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9084 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int cost[] = new int[M + 1];

            cost[0] = 1;

            for(int i = 0; i< N; i++) {
                for(int j = arr[i]; j<=M; j++) {
                    cost[j] += cost[j - arr[i]];
                }
            }

            System.out.println(cost[M]);
        }
    }
}
