package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_20529 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String arr[] = s.split(" ");

            int min_len = Integer.MAX_VALUE;
            if(N>32) min_len = 0;
            else {
                for (int i = 0; i < N; i++) {
                    for(int j = i+1; j<N; j++){
                        for(int k = j+1; k<N; k++){
                            int now_len = 0;
                            now_len += getLen(arr[i], arr[j]);
                            now_len += getLen(arr[i], arr[k]);
                            now_len += getLen(arr[j], arr[k]);
                            min_len = Math.min(min_len, now_len);
                        }
                    }
                }
            }
            System.out.println(min_len);

        }
    }

    static int getLen(String s1, String s2){
        int ans = 0;
        for(int i = 0; i<4; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                ans++;
            }
        }
        return ans;
    }
}
