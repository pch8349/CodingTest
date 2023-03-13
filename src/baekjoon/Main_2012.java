package baekjoon;

import java.io.*;
import java.util.*;
public class Main_2012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long sum = 0;

        Arrays.sort(arr);
        for(int i = 0; i<N; i++){
            sum += Math.abs(i+1-arr[i]);
        }

        System.out.println(sum);
    }
}
