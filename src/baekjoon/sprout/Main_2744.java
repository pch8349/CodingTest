package baekjoon.sprout;
import java.io.*;
public class Main_2744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String ans = "";

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                ans += (char)(s.charAt(i) - 32);
            } else {
                ans += (char)(s.charAt(i) + 32);
            }
        }

        bw.write(ans);
        bw.close();
    }
}
