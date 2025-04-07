package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_9466 {

    static int N;
    static int[] arr;
    static int[] group;
    static int groupIdx;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            group = new int[N];
            groupIdx = 1;
            ans = N;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken())-1;

            // dfs 로 사이클 판별
            for(int i = 0; i<N; i++){
                if(group[i] == 0){
                    dfs(i, groupIdx, 0, new HashMap<>());
                    groupIdx+=1;
                }

            }
            System.out.println(ans);
        }
    }

    public static int dfs(int n, int groupIdx, int cnt, Map<Integer, Integer> map){
        int isNeard = groupIdx;
        // 아직 탐색 안한 노드
        if(group[n] == 0 || group[n] == groupIdx){
            if(map.getOrDefault(n, 0) > 1){
                return isNeard;
            }
            group[n] = groupIdx;
            map.put(n, map.getOrDefault(n, 0) + 1);
            isNeard = dfs(arr[n], groupIdx, cnt+1, map);
        }
        // 탐색은 했지만, 새로운 그룹인 경우 ( 1-> <- 2 <-3 <-4 ) 에서 1, 2, 3 은 탐색했는데, 4 인 경우
        else {
            return group[n];
        }
        group[n] = isNeard;
        if(map.getOrDefault(n, 0) > 1){
            ans -= 1;
            map.remove(n);
        }
        return isNeard;
    }
}