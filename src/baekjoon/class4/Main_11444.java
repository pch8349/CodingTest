package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_11444 {
    static long mod = 1000000007;
    static Map<Long, Long> memo = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        memo.put(0L, 0L);
        memo.put(1L, 1L);
        memo.put(2L, 1L);
        long answer = fib(N);
        System.out.println(answer);
    }

    static long fib(long n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        long a, b, c;
        if(n%2 == 1){
            a = fib(n/2 + 1);
            b = fib(n/2);
            memo.put(n, ((a%mod) * (a%mod)%mod + (b%mod)*(b%mod)%mod)%mod);
        } else {
            a = fib(n/2+1);
            b = fib(n/2);
            c = fib(n/2-1);
            memo.put(n, ((a%mod)*(b%mod)%mod + (b%mod)*(c%mod)%mod)%mod);
        }
        return memo.get(n);
    }
}
