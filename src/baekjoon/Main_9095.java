package baekjoon;

import java.io.*;
import java.util.*;
public class Main_9095 {
    public static void main(String[] args) throws IOException{
        int arr[] = new int [20];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i = 4; i<20; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}
