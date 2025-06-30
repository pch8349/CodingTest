package baekjoon.groupStudy.study05;
import java.io.*;
import java.util.*;
public class Main_1261 {
    static final int INF = 999999;
    static final int[][] MV = {{1,0},{-1,0},{0,1},{0,-1}};
    static int N, M;
    static int[][] map;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0; i<N; i++)Arrays.fill(dist[i], INF);
        dist[0][0] = 0;
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });
        q.add(new int[]{0, 0, 0});

        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int val = q.poll()[2];

            for(int[] mv : MV){
                int nx = x + mv[0];
                int ny = y + mv[1];

                if(nx<0||ny<0||nx>=N||ny>=M) continue;

                int nowVal = val + map[nx][ny];
                if(nowVal < dist[nx][ny]){
                    q.add(new int[]{nx, ny, nowVal});
                    dist[nx][ny] = nowVal;
                }
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}