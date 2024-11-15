package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_15681 {
    static int N, R, Q;
    static List<Integer>[] input;
    static int[]query;
    static int[] subNodeCnt;
    static boolean[] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        input = new List[N+1];
        for(int i = 1; i<=N; i++)input[i] = new ArrayList<>();
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[a].add(b);
            input[b].add(a);
        }

        query = new int[Q];
        for(int i = 0; i<Q; i++) query[i] = Integer.parseInt(br.readLine());

        // dfs 를 활용해 루트 밑의 정점 개수를 전부 저장하기.
        subNodeCnt = new int[N+1];
        visit = new boolean[N+1];
        dfs(R);

        for(int i = 0; i<Q; i++) System.out.println(subNodeCnt[query[i]]);
    }

    static int dfs(int pivot){
        int rt = 1;
        if(!visit[pivot]){
            visit[pivot] = true;
            for(int i : input[pivot]){
                rt += dfs(i);
            }
            subNodeCnt[pivot] += rt;
            return rt;
        }
        else return 0;
    }
}