package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Programmers_튜플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        solution(s);
    }
    public static int[] solution(String s) {
        int rr[] = new int[5];
        ArrayList<Integer> []arr = new ArrayList[500];
        ArrayList<Integer> imsi = new ArrayList<>();
        int n = 0;
        for(int i = 1; i<s.length()-1; i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                n = n*10+(s.charAt(i)-'0');
            }
            else if(s.charAt(i) == ',' && s.charAt(i-1) != '}') {
                imsi.add(n);
                n = 0;
            }
            else if(s.charAt(i) =='}'){
                imsi.add(n);
                n = 0;
                arr[imsi.size()-1] = (ArrayList<Integer>)imsi.clone();
                System.out.println(imsi.toString());
                imsi.clear();
            }
        }
        for(int i = 0; i<500; i++){
            if(arr[i] == null) break;
            Collections.sort(arr[i]);
            System.out.println(arr[i]);
        }
        int[] answer = {};
        return answer;
    }
}

