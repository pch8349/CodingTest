package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_9184 {
    static int [][][]dp = new int[51][51][51];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1&&c==-1) break;

            int x = w(a, b, c);

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(x).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int w(int a, int b, int c){

        if(a<=0||b<=0||c<=0) return 1;
        else if(dp[a][b][c] != 0) return dp[a][b][c];
        else if(a>20||b>20||c>20) return dp[20][20][20] = w(20, 20, 20);
        else if(a<b&&b<c) return dp[a][b][c] = w(a, b, c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        else return dp[a][b][c] = (w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1));
    }

}
