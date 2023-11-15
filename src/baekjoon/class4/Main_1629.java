package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_1629 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(mod(A, B, C));
    }
    // (A+B) %C = (A%C + B%C)%C
    // (A*B)%C = (A%C * B%C)%C
    static long mod(int a, int b, int c){
        if(b==1){
            return a % c;
        }
        long n = mod(a, b/2, c);
        if(b%2 == 0) return n * n % c;
        else return (n * n % c) * a % c;
    }
}
