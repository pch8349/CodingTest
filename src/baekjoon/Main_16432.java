package baekjoon;

import java.io.*;
import java.util.*;
public class Main_16432 {
    static int N;
    static List []arr;
    static boolean [][]check;
    static int []answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        check = new boolean[N+1][10];
        answer = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j<m; j++){
                int n = Integer.parseInt(st.nextToken());
                arr[i].add(n);
            }
        }


        if(dfs(0,1)){
            for(int i = 0; i<N; i++){
                System.out.print(answer[i]+" ");
            }
        } else {
            System.out.println("-1");
        }

    }

    static boolean dfs(int before, int day){
        if(day == N){
            for(int i = 0; i<arr[day-1].size(); i++){
                if(before != (int) arr[day-1].get(i)){
                    answer[day-1] = (int) arr[day-1].get(i);
                    return true;
                }
            }
        }

        for(int i = 0; i<arr[day-1].size(); i++){
            int next = (int) arr[day-1].get(i);

            if(before != next && !check[day+1][next]){
                check[day+1][next] = true;
                answer[day-1] = next;
                if(dfs(next, day+1)) return true;
            }
        }
        return false;
    }
}
