package baekjoon;
import java.io.*;
import java.util.*;
public class Main_2211 {

    static int N;
    static int M;
    static List<Node> [] lists;
    static int distance[];
    static List<int[]> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        lists = new ArrayList[N+1];
        answer = new ArrayList<>();
        for(int i = 0 ;i<=N; i++){
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[b].add(new Node(a, b, c));
            lists[a].add(new Node(b, a, c));
        }

        distance[1] = 0;
        dijk();
        bw.write(String.valueOf(answer.size()));
        bw.write("\n");
        bw.flush();
        for(int i = 0; i<answer.size(); i++){
//            bw.write(String.valueOf(answer.get(i)[0]) + " " + String.valueOf(answer.get(i)[1]));
//            bw.flush();
            System.out.println(answer.get(i)[0]+" "+answer.get(i)[1]);
        }
    }

    static void dijk(){
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 1, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(distance[node.x]<node.val) continue;
            if(node.x != node.y){
                answer.add(new int[]{node.x, node.y});
            }
            for(Node i : lists[node.x]){
                if(distance[node.x] + i.val<distance[i.x]) {
                    pq.add(new Node(i.x, node.x, distance[node.x] + i.val));
                    distance[i.x] = distance[node.x] + i.val;
                }
            }

        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int val;

        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
}
