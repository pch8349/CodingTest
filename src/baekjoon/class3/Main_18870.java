package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];
        int sum[] =  new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));
        sum[arr[0][1]] = 0;
        int n = 0;
        for(int i = 1; i<N; i++){
            if(arr[i-1][0] < arr[i][0]){
                sum[arr[i][1]] = ++n;
            } else {
                sum[arr[i][1]] = n;
            }
        }

        for(int i = 0; i<N; i++){
            bw.write(sum[i]+" ");
        }
        bw.flush();
    }
}