package baekjoon.class1;

import java.io.*;

public class Main_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine()) - 1;
        System.out.println(S.charAt(i));
    }
}