package baekjoon.bronze;

import java.io.*;
import java.util.*;
public class Main_1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int minNum = Integer.MAX_VALUE;
        int maxNum = 0;

        // 굳이 배열 저장 안해도 됨. 입력 들어오는 값 중 최소값과 최대값을 곱하면 정답인 수가 도출됨
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());

            minNum = Math.min(minNum, x);
            maxNum = Math.max(maxNum, x);
        }

        bw.write(String.valueOf(minNum*maxNum));
        bw.flush();
        bw.close();
    }
}