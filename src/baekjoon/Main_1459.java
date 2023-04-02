package baekjoon;

import java.io.*;
import java.util.*;
public class Main_1459 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long ans = 0;
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if(S < W) {
            if(Math.abs(X-Y)%2 == 0) {
                ans += (long)Math.max(X, Y) * S;
            }
            else {
                ans += (long)(Math.max(X, Y) - 1) * S + W;
            }
        }
        else if(S < 2 * W) {
            ans += (long)Math.min(X, Y) * S + (long)Math.abs(X - Y) * W;
        }
        else {
            ans += (long)(X + Y) * W;
        }
        System.out.println(ans);
    }
}
