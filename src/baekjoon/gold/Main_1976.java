package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_1976 {
    static int N, M;
    static int[] route;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N];
        for(int i = 0; i < N; i++)parents[i] = i;
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1){
                    union(i, j);
                }
            }
        }

        route = Arrays.stream(br.readLine().split(" " )).mapToInt(Integer::parseInt).toArray();

        String ans = "YES";
        for(int i = 1; i<M; i++){
            if(!isConnected(route[i-1]-1, route[i]-1)){
                ans = "NO";
            }
        }
        System.out.println(ans);
    }

    static int findParents(int x){
        if(parents[x] == x) return x;
        return x = findParents(parents[x]);
    }

    static void union(int a, int b){
        a = findParents(a);
        b = findParents(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

    static boolean isConnected(int a, int b){
        return findParents(a) == findParents(b);
    }
}
