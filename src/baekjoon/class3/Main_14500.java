package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_14500 {
    static int N;
    static int M;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, stick(i, j));
                ans = Math.max(ans, square(i, j));
                ans = Math.max(ans, twisted(i, j));
            }
        }

        System.out.println(ans);

    }

    static int stick(int x, int y){
        int maxn = 0;
        if(x+3<N) {
            for(int i = 0; i<4; i++){
                maxn += arr[x + i][y];
            }
        }

        if(y+3<M) {
            int tmp = 0;
            for (int i = 0; i < 4; i++) {
                tmp += arr[x][y + i];
            }
            maxn = Math.max(maxn, tmp);
        }
        return maxn;
    }

    static int square(int x, int y){
        int maxn = 0;
        if(x+1<N && y+1<M){
            maxn += arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x+1][y+1];
        }
        return maxn;
    }

    static int twisted(int x, int y){
        int maxn = 0;
        int position[][][] = {{{0, 0}, {1, 0}, {1, 1}, {1, 2}},
                {{0, 0}, {-1, 0}, {-1, 1}, {-1, 2}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
                {{0, 0}, {1, 0}, {1, 1}, {2, 0}}};
        int figure[][] = new int[4][2];

        for(int j = 0; j<5; j++) {
            for (int i = 0; i < 4; i++) {
                figure[i][0] = position[j][i][0] + x;
                figure[i][1] = position[j][i][1] + y;
            }

            for (int i = 0; i < 4; i++) {
                if (isOkay(figure)) maxn = Math.max(maxn, sumPosition(figure));

                figure = rightRotateFigure(figure, position[j]);
                position[j] = rightAngleLotationPosition(position[j]);

            }
        }

        return maxn;
    }

    // 기준점으로 도형 90도 반시계로 돌리는 함수
    static int [][] rightRotateFigure(int [][] figure, int [][]position){
        int rightTurn[][] = rightAngleLotationPosition(position);
        for(int i = 0; i<4; i++){
            figure[i][0] = figure[i][0] - position[i][0] + rightTurn[i][0];
            figure[i][1] = figure[i][1] - position[i][1] + rightTurn[i][1];
        }
        return figure;
    }

    // 90도 반시계로 회전하는 공식 (a, b) => (-b, a)
    static int [][] rightAngleLotationPosition(int [][] position){
        int ans[][] = new int[4][2];
        for(int i = 0; i<4; i++){
            ans[i][0] = -position[i][1];
            ans[i][1] = position[i][0];
        }
        return ans;
    }

    // 배열 나가는지 체크
    static boolean isOkay (int [][]figure){
        for(int i = 0; i<4; i++){
            if(figure[i][0]<0||figure[i][0]>=N) return false;
            if(figure[i][1]<0||figure[i][1]>=M) return false;
        }
        return true;
    }

    static int sumPosition(int [][]figure){
        int ans = 0;
        for(int i = 0; i<4; i++){
            ans += arr[figure[i][0]][figure[i][1]];
        }
        return ans;
    }
}
