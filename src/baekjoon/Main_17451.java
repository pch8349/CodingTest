package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17451 {

    static int N;
    static int []arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long now = 0;
        for(int i = N-1; i>=0; i--){
            if(arr[i]<now) {
                int multi = 0;
                if(now%arr[i]!=0) multi = 1;
                now = arr[i] * (now/arr[i] + multi);
            }
            else {
                now = arr[i];
            }
        }
        System.out.println(now);
    }
}
