package baekjoon.class5;

import java.io.*;
import java.util.*;

public class Main_7453 {
    static int N;
    static int arr[][];
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

        for(int i = 0; i<N*N; i++){
            System.out.println(xArr[i]+" "+yArr[i]);
        }

        /*
            a*b , c*d 배열을 만들어 이분탐색 할 생각이었으나
            양 끝점부터 시작해 탐색했을 때
            pivot 의 값들이 0이 넘어가는 순간 어케 해야할지 생각해야됨
         */

        int x = 0;
        int y = N*N-1;
        int ans = 0;
        while (true) {
            if(x<0 || y < 0 || x>=N*N || y>=N*N){
                break;
            }
            if(xArr[x] + yArr[x] == 0){
                ans++;
            }
        }
    }
}