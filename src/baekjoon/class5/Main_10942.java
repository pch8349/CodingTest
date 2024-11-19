package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_10942 {
    static int N, M;
    static int []nArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        nArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) nArr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            boolean flag = true;
            while (a<b) {
                if(nArr[a] == nArr[b]) {
                    a+=1;
                    b-=1;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) sb.append("1\n");
            else sb.append("0\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}