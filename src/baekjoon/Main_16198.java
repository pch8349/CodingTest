package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = N;

        while(cnt>2) {
            long maxVal = 0;
            long del = -1;
            for(int i = 1; i<cnt-1; i++) {
                long now = list.get(i-1)*list.get(i+1);
                if(now > maxVal) {
                    maxVal = now;
                    del = i;
                }
            }
            cnt-=1;
            ans += maxVal;
            list.remove(del);
        }
        System.out.println(ans);
    }
}
