package baekjoon.groupStudy.study02;
import java.io.*;
import java.util.*;
public class Main_2573 {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > 0) q1.add(new int[]{i, j});
            }
        }

        int ans = 0;
        while(!q1.isEmpty()) {

            int sepereate = sepereateCnt(new LinkedList<>(q1));

            if(sepereate > 1){
                break;
            } else if(sepereate == 0){
                ans = 0;
                break;
            }

            ans++;

            while(!q1.isEmpty()) {
                int[] cur = q1.poll();
                int x = cur[0], y = cur[1];
                int value = melting(x, y);
                q2.add(new int[]{x, y, value});
            }

            while(!q2.isEmpty()) {
                int[] cur = q2.poll();
                int x = cur[0], y = cur[1], value = cur[2];
                arr[x][y] = value;

                if(value > 0) q1.add(new int[]{x, y});
            }
        }

        System.out.println(q1.isEmpty() ? 0 : ans);

        // 빙하들의 연결이 끊어지면 그 때의 년도를 출력하면 됨
        // 큐1에 빙하들의 위치를 x, y 로 저장
        // 큐2에 빙하위치 x y, 녹은후 빙하높이 value 를 저장
        // 큐1 탐색이 끝나면 큐2의 값을 arr 에 최신화 하며 큐1에 저장
        // 0이면 큐1에 저장하지 않음
    }

    static int melting(int x, int y){
        int ans = arr[x][y];

        if(x>0 && arr[x-1][y] == 0) ans--;
        if(y>0 && arr[x][y-1] == 0) ans--;
        if(x<N-1 && arr[x+1][y] == 0) ans--;
        if(y<M-1 && arr[x][y+1] == 0) ans--;

        if(ans<0) ans = 0;

        return ans;
    }

    static int sepereateCnt(Queue<int[]> q){
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[0]][cur[1]]) continue;
            cnt++;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(cur);
            visited[cur[0]][cur[1]] = true;
            while(!queue.isEmpty()){
                int[] cur2 = queue.poll();
                int x = cur2[0], y = cur2[1];
                for(int[] mv : move){
                    int a = x+mv[0], b = y+mv[1];
                    if(a < 0 || a >= N || b < 0 || b >= M) continue;
                    if(arr[a][b] > 0 && !visited[a][b]){
                        visited[a][b] = true;
                        queue.add(new int[]{a, b});
                    }
                }
            }
        }

        return cnt;
    }
}