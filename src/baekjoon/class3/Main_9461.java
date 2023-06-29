package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arr[] = new long[101];
        long tmp[] = new long[]{0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
        System.arraycopy(tmp, 0, arr, 0, 11);
        for(int i = 11; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }
}
