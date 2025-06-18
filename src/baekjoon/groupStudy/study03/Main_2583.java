package baekjoon.groupStudy.study03;

import java.io.*;
import java.util.*;
public class Main_2583 {
    static int N, M, K;
    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        // K 개의 직사각형을 입력받는대로
        // arr 배열에 다 채워서 넣는다. 1로?
        // K번 반복해서 채운 후
        // 0,0 ~ N-1,M-1 까지 탐색을 진행, 0 인 애일때만 dfs 를 돌려서 너비를 계속 합산한 값을
        // list 에 저장한다.

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = b; i < y; i++){
                for(int j = a; j < x; j++){
                    arr[i][j] = 1;
                }
            }
        }

        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\n========\n");

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    list.add(dfs(i, j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }

    static int dfs(int x, int y){
        int sum = 0;
        if(x+1<M && arr[x+1][y] == 0){
            arr[x+1][y] = 1;
            sum += dfs(x+1, y);
        }
        if(x>0 && arr[x-1][y] == 0) {
            arr[x-1][y] = 1;
            sum += dfs(x-1, y);
        }
        if(y>0 && arr[x][y-1] == 0) {
            arr[x][y-1] = 1;
            sum += dfs(x, y-1);
        }
        if(y+1<N && arr[x][y+1] == 0){
            arr[x][y+1] = 1;
            sum += dfs(x, y+1);
        }
        return sum + 1;
    }
}
