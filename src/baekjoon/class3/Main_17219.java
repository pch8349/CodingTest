package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i<N; i++){
            String s[] = br.readLine().split(" ");
            map.put(s[0], s[1]);
        }

        for(int i = 0; i<M; i++){
            System.out.println(map.get(br.readLine()));
        }
    }
}
