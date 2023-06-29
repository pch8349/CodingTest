package baekjoon.class3;

import java.io.*;
import java.util.*;
public class Main_9375 {
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            ans = 0;
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> m = new HashMap<>();
            for(int i = 0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                if(m.containsKey(s)){
                    m.put(s, m.get(s) + 1);
                } else {
                    m.put(s, 1);
                }
            }

            ans = 1;
            for(String key : m.keySet()){
                ans *= (m.get(key)+1);
            }
            System.out.println(--ans);
        }
    }
}