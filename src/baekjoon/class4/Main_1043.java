package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_1043 {
    static int parent[];
    static List<Integer> root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 유니온파인드 부모 정렬
        parent = new int[N+1];
        for(int i = 0; i<=N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int pp = Integer.parseInt(st.nextToken());
        root = new ArrayList<>();
        if(pp == 0) {
            System.out.println(M);
            return;
        } else{
            for(int i = 0; i<pp; i++){
                root.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 멤버들의 초기 입력시 부모를 찾아놓는 과정
        List<Integer>[] party = new ArrayList[M];
        for(int i = 0; i<M; i++){
            party[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int memberCnt = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            party[i].add(x);
            for(int j = 1; j<memberCnt; j++){
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party[i].add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i<M; i++){
            boolean flag = true;
            for(int num : party[i]){
                if(root.contains(find(parent[num]))){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }

        System.out.println(cnt);
    }

    static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int x, int y){
        int xx = find(x);
        int yy = find(y);
        if(root.contains(yy)){
            int tmp = xx;
            xx = yy;
            yy = tmp;
        }
        parent[yy] = xx;
    }
}