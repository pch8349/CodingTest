package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_15666 {

    static int N, M;
    static List<Integer> list = new ArrayList<>();
    static boolean inputCheck[] = new boolean[10001];
    static List<int[]> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(!inputCheck[n]) {
                list.add(n);
                inputCheck[n] = true;
            }
        }
        Collections.sort(list);

        dfs(0, new ArrayList<>());

        for(int [] ims : ans){
            for(int i : ims) System.out.print(i+" ");
            System.out.println();
        }
    }

    static void dfs(int pivot, List<Integer> cover){
        if(cover.size() == M){
            ans.add(cover.stream().mapToInt(Integer::intValue).toArray());
            return;
        }
        for(int i = pivot; i<list.size(); i++){
            cover.add(list.get(i));
            dfs(i, cover);
            cover.remove(cover.size()-1);
        }
    }
}
