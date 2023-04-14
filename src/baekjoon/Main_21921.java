package baekjoon;

import java.io.*;
import java.util.*;

public class Main_21921 {
    static int N;
    static int X;
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i = 0; i<X; i++){
            answer += arr[i];
        }
        int cnt = 1;
        int now = answer;
        for(int i = 1; i<=N-X; i++) {
            now = now - arr[i - 1] + arr[i + X - 1];
            if(answer <= now) {
                if(answer == now) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                answer = now;
            }
        }
        if(answer == 0) bw.write("SAD");
        else {
            StringBuilder sb = new StringBuilder().append(answer).append("\n").append(cnt);
            bw.write(sb.toString());
        }
        bw.flush();
    }
}

