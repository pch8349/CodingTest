package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_17387 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] L1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] L2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long a = ccw(L1[0], L1[1], L1[2], L1[3], L2[0], L2[1]);
        long b = ccw(L1[0], L1[1], L1[2], L1[3], L2[2], L2[3]);
        long c = ccw(L2[0], L2[1], L2[2], L2[3], L1[0], L1[1]);
        long d = ccw(L2[0], L2[1], L2[2], L2[3], L1[2], L1[3]);

        long ans = 0;
        if (a * b == 0 && c * d == 0) {
            if(Math.min(L1[0], L1[2])<=Math.max(L2[0], L2[2])
                    && Math.min(L2[0], L2[2])<=Math.max(L1[0], L1[2])
                    && Math.min(L1[1], L1[3])<=Math.max(L2[1], L2[3])
                    && Math.min(L2[1], L2[3])<=Math.max(L1[1], L1[3])){
                ans = 1;
            }
        } else if (a*b <= 0 && c*d <= 0) {
            ans = 1;
        }

        System.out.println(ans);
    }

    static long ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long r = ( x1*y2 + x2*y3 + x3*y1 ) - ( x2*y1 + x3*y2 + x1*y3 );
        if(r>0) return 1;
        else if(r<0) return -1;
        return 0;
    }
}
