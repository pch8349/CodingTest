package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_1120 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String []sArr = br.readLine().split(" ");

        int sameLength = 0;
        for(int i = 0; i<=sArr[1].length() - sArr[0].length(); i++){
            int tmpLength = 0;
            for(int j = 0; j<sArr[0].length(); j++){
                if(sArr[1].charAt(i+j) == sArr[0].charAt(j)){
                    tmpLength++;
                }
            }
            sameLength = Math.max(sameLength, tmpLength);
        }

        int ans = sArr[0].length() - sameLength;
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}