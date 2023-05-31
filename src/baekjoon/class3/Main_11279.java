package baekjoon.class3;

import java.util.*;
import java.io.*;

public class Main_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x != 0) queue.add(x);
            else {
                int m = queue.isEmpty() ? 0 : queue.poll();
                System.out.println(m);
            }
        }
    }
}
