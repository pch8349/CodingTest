package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_17070 {
    static int N;
    static int house[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1.가로 2.세로 3. 대각선
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 2, 1});
        int answer = 0;

        if(house[N][N] == 1) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            int direct = queue.poll()[2];

            if(x == N && y == N && house[x][y] == 0){
                answer++;
                continue;
            }

            switch (direct) {
                case 1:
                    if(y<N && isEmptySpace(x, y, 1)) queue.add(new int[]{x, y+1, 1});
                    if(y<N && x<N && isEmptySpace(x, y, 3)) queue.add(new int[]{x+1, y + 1, 3});
                    break;
                case 2:
                    if(x<N && isEmptySpace(x, y, 2)) queue.add(new int[]{x+1, y, 2});
                    if(x<N && y<N && isEmptySpace(x, y, 3)) queue.add(new int[]{x+1, y+1, 3});
                    break;
                case 3:
                    if(y<N && isEmptySpace(x, y, 1)) queue.add(new int[]{x, y+1, 1});
                    if(x<N && isEmptySpace(x, y, 2)) queue.add(new int[]{x+1, y, 2});
                    if(x<N && y<N && isEmptySpace(x, y, 3)) queue.add(new int[]{x+1, y+1, 3});
            }
        }
        System.out.println(answer);
    }
    static boolean isEmptySpace(int x, int y, int direct){
        switch (direct){
            case 1:
                if(house[x][y+1] == 0) return true;
                else return false;
            case 2:
                if(house[x+1][y] == 0) return true;
                else return false;
            case 3:
                if(house[x+1][y] == 0 && house[x][y+1] == 0 && house[x+1][y+1] == 0) return true;
                else return false;
        }
        return false;
    }
}