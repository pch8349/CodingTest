package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_1780 {

    static int N;
    static int arr[][];
    static int ans[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = new int[3];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);
        System.out.println(ans[0]+"\n"+ans[1]+"\n"+ans[2]);
    }

    static void solution(int x, int y, int sz){
        if(!checkIsSame(x, y, sz)) {
            for(int i = 0; i<9; i++){
                solution(x + (i/3)*(sz/3), y + (i%3)*(sz/3), sz/3);
            }
        } else {
            ans[arr[x][y]+1]+=1;
        }
    }

    static boolean checkIsSame(int x, int y, int sz){
        for(int i = 0; i<sz; i++){
            for(int j = 0; j<sz; j++){
                if(arr[x][y] != arr[x+i][y+j]){
                    return false;
                }
            }
        }
        return true;
    }
}
