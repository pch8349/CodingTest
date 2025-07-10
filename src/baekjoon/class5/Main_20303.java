package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_20303 {
    static int N, M, K; // N : 아이수, M : 아이친구관계수, K : 울음공명최소아이수
    static int[] candy; // 각 아이들이 받은 캔디 수
    static int[] parents; // 부모
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parents = new int[N];

        candy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 유니온파인드로 그룹화
        for(int i=0; i<N; i++) parents[i] = i;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            connect(a, b);
        }

        // 그룹별로 아이 수, 사탕수 저장
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int n = find(i);
            if(!map.containsKey(n)){
                map.put(n, new int[]{1, candy[i]});
            } else {
                map.put(n, new int[]{map.get(n)[0]+1, map.get(n)[1]+candy[i]});
            }
        }
        int dpEnd = map.size();
        int[][] group = new int[dpEnd+1][2];
        int idx=1;
        for(int[] v : map.values()) group[idx++] = v;

        // 냅색으로 최대 가치 찾기
        int[][] dp = new int[dpEnd+1][K]; // 캔디, 납치수
        for(int i=1; i<=dpEnd; i++){
            for(int j=0; j<K; j++){
                if(group[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-group[i][0]]+group[i][1]);
                }
            }
        }

        System.out.println(dp[dpEnd][K-1]);
    }

    static int find(int x){
        if(parents[x] == x) return parents[x] = x;
        return parents[x] = find(parents[x]);
    }

    static void connect(int A, int B){
        int a = find(A);
        int b = find(B);
        if(a<b) parents[b] = a;
        else parents[a] = b;
    }
}