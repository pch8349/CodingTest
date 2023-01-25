package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();

        System.out.println(solution(numbers));
    }

    static ArrayList<Integer> per_arr = new ArrayList<>();
    static boolean prime[] = new boolean[10000000];
    static boolean check[] = new boolean[8];

    public static int solution(String numbers) {
        int answer = 0;

        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i<prime.length; i++){
            if(prime[i] == false){
                int n = i;
                while((long)(i*n)<(long)10000000){
                    prime[i*n] = true;
                    System.out.println(i+" : "+n+" : "+i*n);
                    n+=1;
                }
            }
        }

        permutation(numbers.length(), "", numbers);

        answer = per_arr.size();

        return answer;
    }

    static void permutation(int len, String made, String numbers) {
        if(len == made.length()){
            int num = Integer.parseInt(made);
            if(!per_arr.contains(num) && !prime[num]){
                per_arr.add(num);
            }
            return;
        }
        else {
            for(int i = 0; i<made.length(); i++){
                if(made.length() == 0 && numbers.charAt(i) == '0') continue;
                if(!check[i]) {
                    check[i] = true;
                    made += numbers.charAt(i);
                    permutation(len, made, numbers);
                    check[i] = false;
                }
            }
        }
    }

}
