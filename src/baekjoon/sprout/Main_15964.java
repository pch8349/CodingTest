package baekjoon.sprout;
import java.io.*;
import java.util.*;
public class Main_15964 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long ans = (long) (A + B) *(A-B);
        System.out.println(ans);
    }
}
