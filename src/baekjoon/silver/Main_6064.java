package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_6064 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 최대공약수 구하기
            int gcd = M; // 최대공약수가 됨
            int b = N;
            int tmp = 0;
            while (b != 0) {
                tmp = b;
                b = gcd % b;
                gcd = tmp;
            }

            // 최소공배수 구하기
            int lcm = M*N/gcd;

            int k = x;

            boolean found = false;

            while(k <= lcm){
                if((k-y)%N == 0){
                    System.out.println(k);
                    found = true;
                    break;
                }
                k += M;
            }
            if(!found){
                System.out.println(-1);
            }
        }
    }
}
