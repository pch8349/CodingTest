package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_17626 {
    static int arr[] = new int[50001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for(int i = 1; i*i<50001; i++){
            arr[i*i] = 1;
        }
        for(int i = 1; i<=N; i++){
            if(arr[i] == 0) dp(i);
        }
        System.out.println(arr[N]);
    }

    static void dp(int n){
        for(int i = 1; i*i<=n; i++){
            if(arr[n] == 0) arr[n] = arr[i*i] + arr[n-i*i];
            else arr[n] = Math.min(arr[n], arr[i*i] + arr[n - i*i]);
        }
    }
}
