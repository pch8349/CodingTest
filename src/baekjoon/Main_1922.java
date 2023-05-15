package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1922 {

//    static int sum;
//    static boolean[] visited;
//    static List<Node> []lists;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        visited = new boolean[N+1];
//        lists = new List[N + 1];
//        sum = 0;
//        for(int i = 0; i<=N; i++){
//            lists[i] = new ArrayList<>();
//        }
//
//        for(int i = 0; i<M; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            lists[a].add(new Node(b, c));
//            lists[b].add(new Node(a, c));
//        }
//        prim(1);
//
//        bw.write(String.valueOf(sum));
//        bw.flush();
//    }
//
//    static void prim(int start){
//        Queue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(start, 0));
//        while(!pq.isEmpty()) {
//            Node p = pq.poll();
//            int node = p.x;
//            int value = p.val;
//
//            if(visited[node]) continue;
//            visited[node] = true;
//            sum += value;
//
//            for(Node next : lists[node]) {
//                if(!visited[next.x]) pq.add(next);
//            }
//        }
//    }
//
//    static class Node implements Comparable<Node> {
//        int x;
//        int val;
//
//        public Node(int x, int val){
//            this.x = x;
//            this.val = val;
//        }
//
//        @Override
//        public int compareTo(Node o){
//            return this.val - o.val;
//        }
//    }
    static int N;
    static int M;
    static int[] parents;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i = 0; i<=N; i++){
            parents[i] = i;
        }
        pq = new PriorityQueue<>();
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        int size = pq.size();
        int sum = 0;
        for(int i = 0; i<size; i++){
            Node node = pq.poll();
            int x = find(node.to);
            int y = find(node.from);

            if(!isSameParent(x, y)) {
                sum += node.value;
                union(node.to, node.from);
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x<y){
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static boolean isSameParent(int x, int y){
        if(x == y) return true;
        return false;
    }

    static int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
    



    static class Node implements Comparable<Node> {
        private int to;
        private int from;
        private int value;

        public Node(int to, int from, int value){
            this.to = to;
            this.from = from;
            this.value = value;
        }
        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
}
