package baekjoon.class3;
import java.io.*;
import java.util.*;

public class Main_5525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        String pn = "";
        for(int i = 0; i<N; i++){
            sb.append("IO");
        }
        sb.append("I");
        pn = sb.toString();

        int ans = kmp(s, pn);
        System.out.println(ans);
    }

    static int kmp(String parent, String pattern){
        int table[] = makeTable(pattern);
        int j = 0;
        int ans = 0;
        for(int i = 0; i<parent.length(); i++){
            while(j>0&&parent.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }
            if(parent.charAt(i) == pattern.charAt(j)){
                if(j==pattern.length() - 1){
                    ans++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    static int [] makeTable(String s){
        int table[] = new int[s.length()];
        int j = 0;
        for(int i = 1; i<s.length(); i++){
            while(j>0 && s.charAt(i) != s.charAt(j)) {
                j=table[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                table[i] = ++j;
            }
        }
        return table;
    }
}
