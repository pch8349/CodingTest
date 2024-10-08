package baekjoon;

import java.io.*;
import java.util.*;
public class Main_2420 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long ans = Math.abs(N-M);
        System.out.println(ans);
    }
}
