package baekjoon.gold;
import java.awt.*;
import java.io.*;
import java.util.*;
public class Main_20040 {
    static int N, M;
    static Point []route;
    static int []parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        route = new Point[M];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            route[i] = new Point(a, b);
        }

        parents = new int[N];
        for(int i = 0; i<N; i++) parents[i] = i;
        int ans = 0;
        for(int i = 0; i<M; i++){
            if(find(route[i].x, route[i].y)){
                ans = i+1;
                break;
            } else {
                union(route[i].x, route[i].y);
            }
        }
        System.out.println(ans);
    }

    static int getParent(int x){
        if(x == parents[x]) return x;
        return parents[x] = getParent(parents[x]);
    }

    static boolean find(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return true;
        else return false;
    }

    static void union(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
}