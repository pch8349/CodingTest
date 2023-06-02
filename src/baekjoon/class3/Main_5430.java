package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_5430 {

    static String dq(Deque<Integer> deque, String s){
        int direct = 1;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'R'){
                direct *= -1;
            } else {
                if(deque.isEmpty()){
                    return "error";
                }
                if(direct > 0){
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while(!deque.isEmpty()){
            if(direct>0) sb.append(String.valueOf(deque.pollFirst()));
            else sb.append(String.valueOf(deque.pollLast()));
            if(deque.size() != 0) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String line = br.readLine();
            line = line.substring(1, line.length()-1);
            StringTokenizer st = new StringTokenizer(line);

            Deque<Integer> deque = new LinkedList<>();
            for(String s : line.split(",")){
                if(!s.equals("")) deque.add(Integer.parseInt(s));
            }
            System.out.println(dq(deque, p));
        }
    }
}
