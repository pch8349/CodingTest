package baekjoon.class5;

import java.io.*;
import java.util.*;
import java.awt.Point;
public class Main_1647 {
    static int N, M, sum, maxConnectedRoute;
    static Node[] route;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        route = new Node[M];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            route[i] = new Node(a, b, c);
        }

        Arrays.sort(route, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 크루스칼 알고리즘 사용.
        // 비용 최소순으로 경로를 정렬
        // 사이클이 형성되지 않을 경우 순차적으로 그래프에 포함시키기
        // 이후 가장 긴 길이인 도로 하나를 끊는다
        parents = new int[N+1];
        for(int i = 0; i<=N; i++) parents[i] = i;

        for(int i = 0; i<M; i++){
            // 동일한 부모를 가르키지 않을 때만 선택
            if(!find(route[i].x, route[i].y)) {
                sum += route[i].cost;
                maxConnectedRoute = Math.max(maxConnectedRoute, route[i].cost);
                unionParent(route[i].x, route[i].y);
            }
        }

        System.out.println(sum - maxConnectedRoute);
    }

    static int getParent(int x){
        if(parents[x] == x) return x;
        return parents[x] = getParent(parents[x]);
    }

    static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a<b) parents[b] = a;
        else parents[a] = b;
    }

    static boolean find(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return true;
        else return false;
    }

    static class Node{
        int x;
        int y;
        int cost;
        Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
