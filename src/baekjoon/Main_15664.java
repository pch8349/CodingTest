package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15664 {
    public static int N, M;
    public static int [] arr;
    public static int [] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ans = new int[M];
        dif(0, 0);
    }

    public static void dif(int st, int n){
        if (n==M) {
            for(int i = 0; i<M; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }
        int check = 0;
        for(int i = st; i<N; i++) {
            if(arr[i] == check) continue;
            ans[n] = arr[i];
            dif(i+1, n+1);
            ans[n] = 0;
            check = arr[i];
        }
    }
}
