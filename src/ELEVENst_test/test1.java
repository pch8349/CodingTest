package ELEVENst_test;

import java.io.*;
import java.util.*;
public class test1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int n = solution(S);
        System.out.println(n);
    }

    public static int solution(String S) {
        Map<Character, Integer> map = new HashMap<>();
        int n = 0;
        for(int i = 0; i<S.length(); i++){
            Character c = S.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for(Character key : map.keySet()){
            if(map.get(key)%2 != 0){
                n++;
            }
        }

        return n;
    }
}
