package baekjoon.class5;

import java.io.*;
import java.util.*;
public class Main_2467 {
    static int N;
    static int solution[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) solution[i] = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = N-1;
        int sum = Integer.MAX_VALUE;
        int ans_l = 0;
        int ans_r = 0;

        while(l < r){
            int now = solution[l]+solution[r];
            if(Math.abs(sum) > Math.abs(now)){
                sum = now;
                ans_l = l;
                ans_r = r;
            }

            if(now > 0) r--;
            else l++;
        }

        System.out.println(solution[ans_l]+" "+solution[ans_r]);
    }
}
