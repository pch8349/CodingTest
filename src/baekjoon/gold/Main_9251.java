package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_9251 {
    static String s1;
    static String s2;
    static int [][]dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();

        int ans = 0;

        dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 1; i<=s1.length(); i++){
            for(int j = 1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                ans = Math.max(dp[i][j], ans);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
