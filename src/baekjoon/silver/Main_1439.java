package baekjoon.silver;
import java.io.*;
public class Main_1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int changeCnt = 0;
        for(int i = 1; i<S.length(); i++){
            if(S.charAt(i-1) != S.charAt(i)) changeCnt++;
        }

        changeCnt = changeCnt/2 + changeCnt%2;

        bw.write(String.valueOf(changeCnt));
        bw.flush();
        bw.close();
    }
}