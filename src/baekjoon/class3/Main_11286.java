package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> positive_q = new PriorityQueue<>();
        Queue<Integer> negative_q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0) positive_q.add(x);
            else if(x<0) negative_q.add(x);
            else {
                if(positive_q.isEmpty() && negative_q.isEmpty()) {
                    System.out.println(0);
                }else if (!negative_q.isEmpty() &&(positive_q.isEmpty() || positive_q.peek()>=Math.abs(negative_q.peek()))) {
                    System.out.println(negative_q.poll());
                } else {
                    System.out.println(positive_q.poll());
                }
            }
        }
    }
}
