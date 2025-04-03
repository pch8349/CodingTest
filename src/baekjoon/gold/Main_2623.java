package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_2623 {
    static int N, M;
    static List<Integer>[] childGraph;
    static int[] nodeCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        childGraph = new List[N + 1];
        nodeCnt = new int[N + 1];
        for(int i = 1; i <= N; i++) childGraph[i] = new ArrayList<>();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int j = 0; j<a-1; j++){
                int y = Integer.parseInt(st.nextToken());
                childGraph[x].add(y);
                nodeCnt[y]++;
                x = y;
            }
        }



        for(int i = 1; i<=N; i++){
            for(int j = 0; j<childGraph[i].size(); j++){
                System.out.print(childGraph[i].get(j)+" ");
            }
            System.out.println();
        }
        System.out.println("==========");
        for(int i = 1; i<=N; i++){
            System.out.println(nodeCnt[i]);
        }

    }
}
