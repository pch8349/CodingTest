package baekjoon;

import java.io.*;

public class Main_2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = N;
        for(int i = N-1; i>=0; i--){
            if(ans == arr[i]) {
                ans--;
            }
        }
        System.out.println(ans);
    }
}
