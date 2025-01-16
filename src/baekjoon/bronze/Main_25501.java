package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_25501 {
    static String s;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<T; tc++){
            cnt = 0;
            s = br.readLine();

            StringBuilder sb = new StringBuilder().append(isPalindrome()).append(" ").append(cnt).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }

    static int recursion(int l, int r){
        cnt+=1;
        if(l>=r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(l+1, r-1);
    }

    static int isPalindrome(){
        return recursion(0, s.length()-1);
    }
}