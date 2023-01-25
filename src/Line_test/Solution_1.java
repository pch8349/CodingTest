package Line_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[][] queries) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int []po = new int[10001];
        int m = 0;
        for(int i = 0; i<10001; i++){
            if(i<Math.pow(2, m)){
                po[i] = (int)Math.pow(2, m);
            }
            else {
                po[i] = (int)Math.pow(2, ++m);
            }
        }

        for(int i = 0; i<queries.length; i++){
            if(map.get(queries[i][0]) == null) {
                map.put(queries[i][0], queries[i][1]);
            }
            else {
                int x = map.get(queries[i][0]);
                int y = x + queries[i][1];
                map.put(queries[i][0], y);
                if(po[x] < po[y]){
                    answer += x;
                }
            }
        }

        return answer;
    }
}
