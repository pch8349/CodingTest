package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int arr[] = new int[N];
            int avg = 0;
            for(int i = 0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                avg += arr[i];
            }

            avg /= N;

            int cnt = 0;
            for(int i = 0; i<N; i++){
                if(arr[i] > avg) cnt+=1;
            }

            // StringBuilder로 소수점 아래 3자리까지 표현하기 위한 발버둥
            double ans = (double)Math.round((double)cnt/N*100000)/1000;

            sb.append(String.valueOf(ans)).append("%\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}