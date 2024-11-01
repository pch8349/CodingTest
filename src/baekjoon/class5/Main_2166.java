package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_2166 {
    static int N;
    static int [][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;
        for(int i = 0; i<N; i++){
            sum += (double) arr[i][0] * arr[(i+1)%N][1];
            sum -= (double) arr[(i+1)%N][0] * arr[i][1];
        }
        System.out.printf("%.1f", Math.abs(sum/2));
    }
}