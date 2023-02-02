package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;

        List<Integer> ret = new ArrayList<>();

        for(int i = N; i>=0; i--) {
            List<Integer> list =  new ArrayList<>();
            list.add(N);
            list.add(i);
            int index = 1;
            while(list.get(index) >= 0) {
                list.add(list.get(index-1)-list.get(index));
                index++;
            }
            if(ans<index) {
                ans = index;
                ret = (List<Integer>) ((ArrayList<Integer>) list).clone();
            }
        }
        System.out.println(ans);
        for(int i = 0; i<ret.size()-1; i++) {
            System.out.print(ret.get(i)+" ");
        }
    }
}
