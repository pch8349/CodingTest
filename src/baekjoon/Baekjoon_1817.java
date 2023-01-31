package baekjoon;
import java.io.*;
import java.util.*;

public class Baekjoon_1817 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int sum = 0, cnt = 0;
        if(N!=0) {
            st = new StringTokenizer(br.readLine());
            cnt = 1;
        }

        for(int i = 0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            sum += n;
            if(sum>M) {
                cnt++;
                sum = n;
            }
        }

        System.out.println(cnt);
    }
}
