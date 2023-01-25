package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Programmers_성격유형검사하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String survey[] = new String[n];
        int choices[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            survey[i] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            choices[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(survey, choices));

    }

    public static String solution(String[] survey, int[] choices){
        String answer = "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for(int i = 0; i< survey.length; i++){
            Character a = Character.valueOf(survey[i].charAt(0));
            Character b = survey[i].charAt(1);
            if(choices[i]<4){
                Integer integer = map.get(a) + Integer.valueOf(4 - choices[i]);
                map.put(a, integer);
            }
            else if(choices[i]>4){
                Integer integer = map.get(b) + choices[i] - 4;
                map.put(b, integer);
            }
        }

        if(map.get('R') >= map.get('T')) {
            answer += 'R';
        } else {
            answer += 'T';
        }
        if(map.get('C') >= map.get('F')){
            answer+='C';
        }else {
            answer += 'F';
        }
        if (map.get('J') >= map.get('M')) {
            answer += 'J';
        } else {
            answer += 'M';
        }
        if(map.get('A') >= map.get('N')){
            answer += 'A';
        } else {
            answer += 'N';
        }

        return answer;
    }
}
