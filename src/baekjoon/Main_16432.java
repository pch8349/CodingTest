package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16432 {
    static int N;
    static List<Integer> [] list;
    static int []ans;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            for(int j = 0; j<m; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        ans = new int[N];
        teok(0, 0);
        if(!flag) System.out.println(-1);
    }
    static void teok(int n, int yesterday){

        if(n==N) {
            flag = true;
            for(int i = 0; i<N; i++){
                System.out.println(ans[i]);
            }
            return;
        }
        for(int i = 0; i<list[n].size(); i++){
            if(yesterday != list[n].get(i)) {
                if(flag) return;
                ans[n] = list[n].get(i);
                teok(n+1, list[n].get(i));
                ans[n] = 0;
            }
        }
    }
}
