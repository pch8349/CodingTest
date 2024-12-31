package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_15900 {
    static int N;
    static List<Integer> tree[];
    static int dept;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];

        for(int i = 0; i<=N; i++) tree[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0, 0);

        StringBuilder sb = new StringBuilder();
        if(dept%2==0) sb.append("No");
        else sb.append("Yes");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int n, int before, int len){
        for(int i : tree[n]){
            if(before != i) {
                dfs(i, n, len+1);
            }
        }

        if(tree[n].size() == 1){
            dept += len;
        }
    }
}
