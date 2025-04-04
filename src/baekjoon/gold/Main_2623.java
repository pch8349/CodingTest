package baekjoon.gold;

import java.io.*;
import java.util.*;
public class Main_2623 {

    static class Node{
        int idx;
        int n;
        Node(int idx, int n){
            this.idx = idx;
            this.n = n;
        }
    }

    static int N, M;
    static List<Integer>[] childGraph;
    static Node[] nodeCnt;
    static final int fin = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        childGraph = new List[N + 1];
        nodeCnt = new Node[N + 1];
        for(int i = 1; i <= N; i++) {
            childGraph[i] = new ArrayList<>();
            nodeCnt[i] = new Node(i, 0);
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int j = 0; j<a-1; j++){
                int y = Integer.parseInt(st.nextToken());
                childGraph[x].add(y);
                nodeCnt[y].n++;
                x = y;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.n - o2.n);

        for(int i = 1; i<=N; i++) pq.add(nodeCnt[i]); // 번호, 연결차수

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.n == fin){
                break;
            }
            else if(cur.n > 0){
                sb = new StringBuilder().append(0);
                break;
            } else {
                sb.append(cur.idx).append("\n");
                for(int i = 0; i<childGraph[cur.idx].size(); i++){
                    nodeCnt[childGraph[cur.idx].get(i)].n -= 1;
                }
                nodeCnt[cur.idx].n = fin;
            }

            pq.clear();
            for (int i = 1; i <= N; i++) {
                if (nodeCnt[i].n != fin) {
                    pq.add(nodeCnt[i]);
                }
            }
        }
        System.out.println(sb);
    }
}