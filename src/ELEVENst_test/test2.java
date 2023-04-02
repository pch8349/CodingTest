package ELEVENst_test;

import java.io.*;
import java.util.*;
public class test2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = solution(s);
        System.out.println(n);
    }

    public static int solution(String S){
        Queue<Integer> queue = new LinkedList<>();

        int n = S.length();
        int maxn = 0;

        for(int i = 0; i<n; i++){
            int sumx = 0;
            if(S.charAt(i) != '>') {
                int nx = i;
                while(nx<n && S.charAt(nx) != '>'){
                    sumx++;
                    nx++;
                    if(S.charAt(nx) == '?'){
                        queue.add(nx);
                    }
                }
                int x = 0;
                while(nx<n && S.charAt(nx) != '<'){

                }

            }

        }
        return 1;
    }
}