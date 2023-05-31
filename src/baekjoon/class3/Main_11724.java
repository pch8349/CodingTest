package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_11724 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> [] list = new List[N+1];
        boolean [] visit = new boolean[N+1];

        for(int i = 0 ;i<=N; i++) list[i] = new ArrayList<>();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int ans = 0;
        for(int i = 1; i<=N; i++){
            if(visit[i]) continue;
            ans++;
            visit[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while(!queue.isEmpty()){
                int n = queue.poll();
                for(int j : list[n]){
                    if(visit[j]) continue;

                    queue.add(j);
                    visit[j] = true;
                }
            }
        }

        System.out.println(ans);
    }
}
