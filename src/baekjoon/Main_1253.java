package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1253 {
    static int N;
    static int []arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0; i<N; i++){
            int ll = 0;
            int rr = N-1;
            while(true){
                if(ll == i) ll++;
                else if(rr == i) rr--;
                int n = arr[ll]+arr[rr];
                if(ll>=rr) break;
                if(arr[i] == n && ll != i && rr != i){
                    ans++;
                    break;
                } else if(arr[i]>n){
                    ll++;
                } else {
                    rr--;
                }
            }
        }

        System.out.println(ans);
    }
}
