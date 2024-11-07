package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_1005 {
    static int N, K, destiny;
    static int[] buildCost; // 빌딩 짓는 비용 입력 정보 저장된 배열
    static int[] indegree; // 각 노드들이 도착점으로 주어지는 개수를 저장. 값이 0 인 노드는 시작점이라는 이야기이다.
    static int[] maxCost; // 시작점에서 각 빌딩의 위치까지 빌딩을 짓는 비용의 최대값 저장.
    static List<Integer>[] way; // 연결 간선 입력값 저장 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            buildCost = new int[N+1];
            way = new List[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=N; i++){
                buildCost[i] = Integer.parseInt(st.nextToken());
                way[i] = new ArrayList<>();
            }

            indegree = new int[N+1];
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                way[a].add(b);
                indegree[b]++;
            }
            destiny = Integer.parseInt(br.readLine());
            maxCost = new int[N+1];

            topologySort();
            System.out.println(maxCost[destiny]);
        }
    }

    static void topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<indegree.length; i++){
            if(indegree[i] == 0){
                maxCost[i] = buildCost[i];
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 0; i<way[now].size(); i++){
                int next = way[now].get(i);
                maxCost[next] = Math.max(maxCost[now] + buildCost[next], maxCost[next]);
                indegree[next]-=1;

                // indegree 가 0 일때서야 모든 부모노드에서의 탐색을 끝냈으니 그때 queue에 넣어준다.
                if(indegree[next] == 0) queue.offer(next);
            }
        }
    }
}