package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1931 {
    static int N;
    static int [][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
        });


        int ans = 1;
        int before = 0;
        for(int i = 1; i<N; i++){
            if(arr[before][1] <= arr[i][0]){
                before = i;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
