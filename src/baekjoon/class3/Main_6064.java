package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_6064 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = euclidean(Math.max(M, N), Math.min(M, N));
            int lcm = N*M/gcd;
            int idx = x;
            int ans = -1;
            while(idx <= lcm){
                int per = idx % N;
                if(per == 0) per = N;
                if(per == y){
                    ans = idx;
                    break;
                }
                idx += M;
            }
            System.out.println(ans);
        }
    }
    static int euclidean (int n, int m){
        while(n%m!=0){
            int x = n;
            n = m;
            m = x%m;
        }
        return m;
    }
}
