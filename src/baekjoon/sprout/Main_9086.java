package baekjoon.sprout;
import java.io.*;
import java.util.*;
public class Main_9086 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++){
            String s = br.readLine();
            System.out.println(s.charAt(0)+""+s.charAt(s.length()-1));
        }
    }
}
