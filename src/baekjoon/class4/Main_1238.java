package baekjoon.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1238 {

    static final int INF = 999999999;
    static int N;
    static int M;
    static int X;

    static int distance[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> reverseList = new ArrayList<>(); // 역방향 가중치그래프를 만들어야, 모든 점에서 X 로 오는 최단 경로를 구할 수 있음

        for(int i = 0; i<=N; i++){
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            reverseList.get(b).add(a);
            list.get(a).add(c);
            reverseList.get(b).add(c);
        }

        int ans[] = new int[N+1];
        dijkstra(list);
        for(int i = 1; i<=N; i++) ans[i] += distance[i];
        dijkstra(reverseList);
        int maxN = 0;
        for(int i = 1; i<=N; i++) {
            maxN = Math.max(maxN, ans[i] + distance[i]);
        }

        System.out.println(maxN);
    }

    static void dijkstra(List<List<Integer>> list){
        distance = new int[N+1];
        visit = new boolean[N+1];
        visit[X] = true;
        Arrays.fill(distance, INF);
        distance[X] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int []>(){
            @Override
            public int compare(int o1[], int o2[]){
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{X, 0});
        while(!pq.isEmpty()){
            int dis = pq.peek()[1];
            int pivot = pq.poll()[0];
            for(int i = 0; i < list.get(pivot).size(); i+=2){
                int nextLoc = list.get(pivot).get(i);
                int nextDis = list.get(pivot).get(i+1);
                if(visit[nextLoc]) continue;
                if(dis + nextDis < distance[nextLoc]){
                    distance[nextLoc] = dis + nextDis;
                    pq.add(new int[]{nextLoc, distance[nextLoc]});
                }
            }
            visit[pivot] = true;
        }
    }
}
