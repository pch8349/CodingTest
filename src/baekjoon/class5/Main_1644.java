package baekjoon.class5;

import java.io.*;
import java.util.*;

public class Main_1644 {
    static int N;
    static List<Integer> primeNumbers = new ArrayList<>();
    static boolean eratos[];
    static final int INF = 4000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eratos = new boolean[INF];

        /**
         * 소수 표 구하기 ~ 4,000,000(4백만)
         * 투 포인터 이용, sum 이 N 보다 작으면 오른쪽에서 더해주기, 크면 왼쪽에서 빼주기 방식.
         */

        for(int i = 2; i * i < INF; i++){
            if(eratos[i] == true) continue;
            int ims = i;
            while(i * ims < INF) {
                eratos[i*ims++] = true;
            }
        }

        for(int i = 2; i < INF; i++) {
            if (!eratos[i]) primeNumbers.add(i);
        }

        int sum = primeNumbers.get(0);
        int l = 0;
        int r = 0;
        int ans = 0;
        while(l <= r){
            if(sum > N) {
                sum -= primeNumbers.get(l++);
            }
            else if(sum < N){
                r+=1;
                if(r == primeNumbers.size()) break;
                sum += primeNumbers.get(r);
            }
            else {
                ans++;
                sum -= primeNumbers.get(l++);
            }
        }

        System.out.println(ans);
    }
}