package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_15663 {
    static int N, M;
    static int arr[];
    static boolean check[];
    static Map<String, Integer> map;
    static List<String> ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        map = new HashMap<>();
        ans = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, new ArrayList<>());

        for(String s : ans){
            System.out.println(s);
        }
    }

    static void dfs(int cnt, List<Integer> list){
        if(cnt == M){
            String s = "";
            for(int i : list){
                s += String.valueOf(i)+ " ";
            }
            s = s.substring(0, s.length()-1);
            if(!map.containsKey(s)){
                map.put(s, 0);
                ans.add(s);
            }

            return;
        }
        for(int i = 0; i<N; i++){
            if(!check[i]) {
                check[i] = true;
                list.add(arr[i]);
                dfs(cnt + 1, list);
                check[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
