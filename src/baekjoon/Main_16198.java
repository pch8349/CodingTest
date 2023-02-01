package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16198 {
    public static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = N;

        energy(list, 0);
        System.out.println(ans);
    }

    public static void energy(List<Integer> list, int sum){
        if(list.size()<3) {
            ans = ans>sum ? ans : sum;
            return;
        }
        for(int i = 1; i<list.size()-1; i++) {
            int tmp = list.get(i);
            list.remove(i);
            energy(list, sum + list.get(i-1)*list.get(i));
            list.add(i, tmp);
        }
    }
}
