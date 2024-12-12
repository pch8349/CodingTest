package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_2143 {
    static int T, N, M;
    static int []A;
    static Map<Integer, Integer> a = new HashMap<>();
    static int []B;
    static Map<Integer, Integer> b = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new int[M];
        for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

        /**
         * A, B 배열의 모든 부분배열을 구해, 합을 key, 개수를 value로 hashMap에 각각 저장한다. 시간은 100만(N^2)
         * 각 map 최대 개수는 50만, 50만의 개수이다.
         * A 맵 모든 key 값에서 T를 뺀 값이 B 에 존재하는지 확인
         * 존재하면 A value, B value 값을 곱해준다.
         */

        a = Map.copyOf(fillSubRangeSum(N, A));
        b = Map.copyOf(fillSubRangeSum(M, B));

        Long ans = 0L;
        for(int i : a.keySet()){
            if(b.containsKey(T - i)){
                ans += (long) a.get(i) * b.get(T - i);
            }
        }

        System.out.println(ans);
    }

    public static Map<Integer, Integer> fillSubRangeSum(int n, int[] Arr){
        Map<Integer, Integer> nodes = new HashMap<>();
        for(int i = 0; i < n; i++){
            int ims = 0;
            for(int j = i; j < n; j++){
                ims += Arr[j];
                if(nodes.containsKey(ims)) nodes.put(ims, nodes.get(ims) + 1);
                else nodes.put(ims, 1);
            }
        }
        return Map.copyOf(nodes);
    }
}