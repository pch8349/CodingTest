package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_9019 {
    static Queue<Integer> q;
    static String check[];
    static int N;
    static int M;

    static boolean saving(int n, int m, String s){
        if(check[m]==null){
            check[m] = check[n] + s;
            q.add(m);
            if(m == M) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            check = new String[10001];

            q.add(N);
            check[N] = "";

            while(!q.isEmpty()){
                int n = q.poll();

                int m = (n*2)%10000;
                if(saving(n, m, "D")) break;

                m = n-1 < 0 ? 9999 : n-1;
                if(saving(n, m, "S")) break;

                m = n/1000 + (n%1000)*10;
                if (saving(n, m, "L")) break;

                m = (n%10)*1000 + n/10;
                if (saving(n, m, "R")) break;
            }
            System.out.println(check[M]);
        }
    }
}
