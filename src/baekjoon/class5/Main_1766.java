package baekjoon.class5;

import java.io.*;
import java.util.*;
public class Main_1766 {

    static int N, M;
    static List<Integer>[] arr;
    static int[] course;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new List[N+1];
        for(int i = 0; i < N+1; i++) arr[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        course = new int[N+1];
        for(int i = 1; i <= N; i++){
            for(int j : arr[i]){
                course[j] += 1;
            }
        }

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i<=N; i++){
            if(course[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int i : arr[cur]){
                course[i] -= 1;
                if(course[i] == 0) queue.add(i);
            }
        }

        System.out.println(sb.toString());
    }
}