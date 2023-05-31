package baekjoon.class3;

import java.util.*;
import java.io.*;
public class Main_2630 {
    static int N;
    static int paper[][];
    static int ans[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        ans = new int[2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(N, 0, 0);
        System.out.println(ans[0]+"\n"+ans[1]);
    }

    static int cut(int n, int x, int y){
        if(n!=1){
            int a = cut(n/2, x, y);
            int b = cut(n/2, x+n/2, y);
            int c = cut(n/2, x, y+n/2);
            int d = cut(n/2, x+n/2, y+n/2);
            if(a==b&&a==c&&a==d&&a!=-1&&n==N){
                ans[a]++;
            }
            if(a==b&&a==c&&a==d&&a!=-1){
                return a;
            } else {
                if (a != -1) {
                    ans[a]++;
                } if (b != -1) {
                    ans[b]++;
                } if (c != -1) {
                    ans[c]++;
                } if (d != -1) {
                    ans[d]++;
                }
                return -1;
            }
        } else {
            return paper[x][y];
        }
    }
}
