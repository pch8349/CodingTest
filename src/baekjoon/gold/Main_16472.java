package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_16472 {
    static int N;
    static String S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;

        while(r < S.length()){
            char rc = S.charAt(r);

            if(map.containsKey(rc)){
                map.put(rc, map.get(rc)+1);
            } else {
                map.put(rc, 1);
            }

            while(map.size() > N && l <= r){
                char lc = S.charAt(l);
                map.put(lc, map.get(lc)-1);
                if(map.get(lc) == 0) map.remove(lc);
                l++;
            }

            maxLen = Math.max(maxLen, 1 - l + r++);
        }

        System.out.println(maxLen);
    }
}