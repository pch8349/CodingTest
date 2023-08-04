package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_11403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) arr[i][j] = 1000;
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<N; k++){
                    if(arr[j][i] + arr[i][k] < arr[j][k]){
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(arr[i][j] != 1000)System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

    }
}
