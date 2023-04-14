package baekjoon;

import java.io.*;
import java.util.*;
public class Main_1504 {
    static final int INF = 200000001;
    static int N;
    static int M;
    static List<Node> [] edges;
    static int [][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        for(int i = 0; i<=N; i++) edges[i] = new ArrayList<>();
        arr = new int[N+1][N+1];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].add(new Node(b, c));
            edges[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int mv_1 = Integer.parseInt(st.nextToken());
        int mv_2 = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            Arrays.fill(arr[i], INF);
        }
        dijk(1);
        dijk(N);
        dijk(mv_1);
        dijk(mv_2);
        for(int i = 1; i<=N; i++){
            for(int j : arr[i]){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        //    0       1        2          3
        //시작 : 1   N : 4   mv_1 : 2   mv_2 : 3
        int answer = 0;
        if(arr[1][mv_1]+arr[mv_1][mv_2]+arr[mv_2][N] < arr[1][mv_2]+arr[mv_2][mv_1]+arr[mv_1][N]) {
            answer = arr[1][mv_1]+arr[mv_1][mv_2]+arr[mv_2][N];
            if(arr[1][mv_1]==INF||arr[mv_1][mv_2]==INF||arr[mv_2][N]==INF) answer = -1;
        } else {
            answer = arr[1][mv_2]+arr[mv_2][mv_1]+arr[mv_1][N];
            if(arr[1][mv_2]==INF||arr[mv_2][mv_1]==INF||arr[mv_1][N]==INF) answer = -1;
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void dijk(int start){
        arr[start][start] = 0;
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(Node i : edges[node.x]){
                if(node.val + i.val >= arr[start][i.x]) continue;
                pq.add(new Node(i.x, node.val + i.val));
                arr[start][i.x] = node.val + i.val;
            }
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int val;
        Node (int x, int val){
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val-o.val;
        }
    }
}
