package baekjoon.class5;

import java.io.*;
import java.util.*;
public class Main_1766 {
    static int N, M;
    static List<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new List[N+1];
        for(int i = 0; i < N+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < N+1; i++){
            System.out.print(i+" : ");
            for(int j : arr[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
