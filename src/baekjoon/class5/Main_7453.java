package baekjoon.class5;

import java.io.*;
import java.util.*;

public class Main_7453 {
    static int[][] arr;
    static int[] xArr;
    static int[] yArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][4];
        xArr = new int[N*N];
        yArr = new int[N*N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arr[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                xArr[i*N+j] = arr[i][0] + arr[j][1];
                yArr[i*N+j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int x = 0;
        int y = N*N-1;
        long ans = 0;
        while (true) {
            if(y < 0 || x>=N*N){
                break;
            }
            if(xArr[x] + yArr[y] == 0){
                // x 값 증가시키기
                int tmpX = x;
                long xTmpCnt = 1;
                while(true){
                    x++;
                    if(x<N*N && xArr[x] == xArr[tmpX]) {
                        xTmpCnt++;
                    } else {
                        break;
                    }
                }
                // y 값 감소시키기
                int tmpY = y;
                long yTmpCnt = 1;
                while(true){
                    y--;
                    if(y>=0 && yArr[y] == yArr[tmpY]){
                        yTmpCnt++;
                    } else {
                        break;
                    }
                }
                ans += xTmpCnt * yTmpCnt;
                // 둘 다 해봐야함.
            } else if(xArr[x] + yArr[y] < 0){
                x++;
            } else {
                y--;
            }
        }

        System.out.println(ans);
    }
}