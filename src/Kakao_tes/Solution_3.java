package Kakao_tes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int [] emoticons = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j = 0; j<m; j++){
            emoticons[j] = Integer.parseInt(st.nextToken());
        }

        int ans[] = solution(arr, emoticons);
        for(int i = 0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] arr = new int[emoticons.length];
        permutation(users, emoticons, arr, 0);
        return ans;
    }
    public static int []ans = new int[2];
    public static void permutation(int[][] users, int[] emoticons, int[] arr, int st){
        if(st == emoticons.length) {
            int ret[] = new int[users.length];
            for(int i = 0; i<users.length; i++){
                for(int j = 0; j<emoticons.length; j++) {
                    if(users[i][0] <= arr[j]){
                        ret[i] += emoticons[j] * (100 - arr[j]) /100;
                    }
                }
            }
            int join = 0, cost = 0;
            for(int i = 0; i<users.length; i++){
                if(ret[i] > users[i][1]) join += 1;
                else cost += ret[i];
            }
            if(join>ans[0]) {
                ans[0] = join;
                ans[1] = cost;
            }
            else if(join == ans[0]) {
                ans[1] = Math.max(ans[1], cost);
            }

            return;
        }
        for(int i = 1; i<5; i++){
            arr[st] = i*10;
            permutation(users, emoticons, arr, st + 1);
        }
    }
}
