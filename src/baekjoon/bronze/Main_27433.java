package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_27433 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        long ans = 1;

        for(int i = 1; i<=N; i++) ans *= i;

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}