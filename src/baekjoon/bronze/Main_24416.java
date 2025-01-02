package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_24416 {
    static int N;
    static int []f;
    static int cnt1, cnt2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        f = new int[N+1];
        f[1] = 1;
        f[2] = 1;

        fib(N);
        fibonacci(N);

        StringBuilder sb = new StringBuilder().append(cnt1).append(" ").append(cnt2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int fib(int n){
        if(n == 1 || n == 2){
            cnt1++;
            return 1;
        } else return fib(n-1) + fib(n-2);
    }

    static int fibonacci(int n){
        for(int i = 3; i<=N; i++){
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[N];
    }
}
