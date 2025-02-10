package baekjoon.bronze;
import java.io.*;
public class Main_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int minOdd = 101;
        int sumOdd = 0;

        for(int i = 0; i<7; i++){
            int n = Integer.parseInt(br.readLine());
            if(n%2 == 1){
                minOdd = Math.min(minOdd, n);
                sumOdd = sumOdd + n;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(sumOdd == 0) {
            sb.append("-1");
        } else {
            sb.append(sumOdd).append("\n").append(minOdd);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
