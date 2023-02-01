package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;

        List<Integer> ret = new ArrayList<>();

        for(int i = N; i>=0; i--) {
            ans = 1;
            List<Integer> list =  new ArrayList<>();
            list.add(N);
            list.add(i);
            while(list.get(list.size()-1) >= 0) {

            }
        }
    }
}
