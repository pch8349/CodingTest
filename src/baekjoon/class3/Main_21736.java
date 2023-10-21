package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_21736 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char arr[][] = new char[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'I') {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int mv[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = 0;

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            for(int i = 0; i<4; i++){
                int a = x + mv[i][0];
                int b = y + mv[i][1];
                if(a<0||b<0||a>=N||b>=M||arr[a][b]=='I'||arr[a][b]=='X') continue;
                if(arr[a][b] == 'P') ans++;
                queue.add(new int[]{a, b});
                arr[a][b] = 'I';
            }
        }

        if(ans !=0) System.out.println(ans);
        else System.out.println("TT");

    }
}
