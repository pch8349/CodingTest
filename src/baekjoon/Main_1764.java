package baekjoon;

import java.io.*;
import java.util.*;
public class Main_1764 {
    static int N;
    static int M;
    static Map<String, String> a = new HashMap<>();
    static Map<String, String> b = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            a.put(s, s);
        }

        for(int i = 0; i<M; i++){
            String s = br.readLine();
            b.put(s, s);
        }

        for(String s : a.keySet()){
            if(b.containsKey(s)){
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
