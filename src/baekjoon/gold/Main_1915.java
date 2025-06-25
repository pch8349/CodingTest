package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_1915 {
    static int N, M;
    static int[][] arr;
    static List<int[]>[] loc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(arr[i][j] == 0) {}
                else if(i == 0 || j == 0) {
                    if(arr[i][j] == 1) ans = Math.max(ans, 1);
                } else {
                    arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i][j-1],arr[i-1][j])) + 1;
                    ans = Math.max(ans, arr[i][j]);
                }
            }
        }

        System.out.println(ans*ans);
    }
}
