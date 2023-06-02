package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_2579 {
    static int N;
    static int []arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int steps[] = new int[N+1];
        steps[1] = arr[1];
        if(N>1) steps[2] = arr[1] + arr[2];
        if(N>2) steps[3] = Math.max(arr[1], arr[2]) + arr[3];

        for(int i = 4; i<=N; i++){
            steps[i] = Math.max(steps[i-3]+arr[i-1], steps[i-2]) + arr[i];
        }
        System.out.println(steps[N]);
    }
}
