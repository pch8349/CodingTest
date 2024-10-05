package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int ans = Integer.MAX_VALUE;

        Queue<Gy> queue = new LinkedList<>();
        queue.add(new Gy(N, 1));

        while(!queue.isEmpty()){
            Gy gy = queue.poll();
            if(gy.l == M){
                ans = Math.min(ans, gy.cnt);
                continue;
            }
            long plusOneValue = gy.l * 10 + 1;
            long doubleValue = gy.l * 2;
            if(plusOneValue <= M){
                queue.add(new Gy(plusOneValue, gy.cnt + 1));
            }
            if(doubleValue <= M){
                queue.add(new Gy(doubleValue, gy.cnt + 1));
            }
        }
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }
}

class Gy{
    long l;
    int cnt;
    Gy(long l, int cnt){
        this.l = l;
        this.cnt = cnt;
    }
}
