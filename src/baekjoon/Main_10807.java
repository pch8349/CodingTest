package baekjoon;

import java.io.*;
import java.util.*;
public class Main_10807 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i = 0; i<N; i++){
            if(v == arr[i]) ans++;
        }

        System.out.println(ans);
    }
}
