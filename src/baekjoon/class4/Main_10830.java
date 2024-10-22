package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_10830 {
    static int N;
    static long B;
    static long[][] matrix;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long ans[][] = divide(B);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(ans[i][j]%1000+" ");
            }
            System.out.println();
        }
    }

    public static long[][] multiplyMatrix(long[][] A, long[][] B){
        long rt[][] = new long[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){

                for(int k = 0; k<N; k++){
                    rt[i][j] += A[i][k] * B[k][j];
                }
                rt[i][j] %= 1000;
            }
        }
        return rt;
    }

    public static long[][] divide(long n){
        long twoMultiply = 1;
        long remainder = 0;
        int cnt=0;

        long [][]itsme = new long[N][N];
        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++) itsme[i][j] = matrix[i][j];
        }

        while(twoMultiply<=n){
            cnt++;
            twoMultiply*=2;
        }
        cnt--;
        twoMultiply/=2;

        for(int i = 0; i<cnt; i++){
            itsme = multiplyMatrix(itsme, itsme);
        }

        remainder = n - twoMultiply;

        if(remainder > 1) {
            long [][]asdf = divide(remainder);
            return multiplyMatrix(itsme, asdf);
        } else if(remainder==1){
            return multiplyMatrix(itsme, matrix);
        }

        return itsme;

    }
}