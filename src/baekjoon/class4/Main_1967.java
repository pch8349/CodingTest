package baekjoon.class4;

import java.io.*;
import java.util.*;

class Node{
    int child;
    int weight;

    Node(int child, int weight){
        this.child = child;
        this.weight = weight;
    }
}

public class Main_1967 {
    static int N;
    static List<Node>[] tree;
    public static void main(String[] args) throws IOException{

        Node node = new Node(12, 245);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for(int i = 0; i<N; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b, c));
            tree[b].add(new Node(a, c));
        }


        //bfs 로 트리의 지름을 탐색. 루트 노드는 0 ~ N-1 까지 정하고 탐색한다.
        int diameter = 0;
        int root = 0;
        for(int i = 0; i<2;i++) {

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(root, 0));

            boolean check[] = new boolean[N];
            check[root] = true;

            // 모든 노드에서 bfs 최장 길이를 비교하면 된다!
            while(!queue.isEmpty()) {

                Node now = queue.poll();
                if(now.weight > diameter){
                    root = now.child;
                    diameter = now.weight;
                }

                for(int j = 0; j<tree[now.child].size(); j++){

                    Node connected = tree[now.child].get(j);

                    // 이미 방문을 한 노드면 넘어가기
                    if(check[connected.child]) continue;

                    queue.add(new Node(connected.child, connected.weight + now.weight));
                    check[connected.child] = true;
                }
            }

        }
        System.out.println(diameter);

    }
}
