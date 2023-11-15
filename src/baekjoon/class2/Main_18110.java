package baekjoon.class2;

import java.io.*;
import java.util.*;

public class Main_18110 {
    static int N;
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int ans = 0;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int round = Math.round(15*(float)N/100);

        for(int i = round; i<N-round; i++){
            ans += arr[i];
        }
        ans = Math.round((float)ans/(N-2*round));

        System.out.println(ans);
    }
}
