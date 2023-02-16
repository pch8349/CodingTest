package baekjoon;

import java.util.*;
import java.io.*;

public class Main_15779 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxn = 0;

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int tmp = 2;
        for(int i = 0; i<n-2; i++) {
           if(arr[i] <= arr[i+1] && arr[i+1] <= arr[i+2]) {
               tmp = 2;
           }
           else if(arr[i]>=arr[i+1]&&arr[i+1]>=arr[i+2]) {
               tmp = 2;
           }
           else {
               tmp++;
           }
           maxn = Math.max(maxn, tmp);
        }

        System.out.println(maxn);
    }
}
