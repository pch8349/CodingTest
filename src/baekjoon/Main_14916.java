package baekjoon;

import java.io.*;

public class Main_14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = -1;
        for(int i = 0; i * 5 <= n; i++){
            if((n - i * 5)%2 == 0){
                ans = i + (n-i*5)/2;
            }
        }
        System.out.println(ans);
    }
}
