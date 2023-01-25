package Kakao_tes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String today = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String terms[] = new String[n];
        for(int i = 0; i<n; i++){
            terms[i] = br.readLine();
        }
        int m = Integer.parseInt(br.readLine());
        String privacies[] = new String[m];
        for(int i = 0; i<m; i++){
            privacies[i] = br.readLine();
        }
        int []arr = solution(today, terms, privacies);
        System.out.println(arr[0]);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = dateToInt(today);
        ArrayList<Integer> arr = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // 약관 종류 바로 읽게 맵에 저장
        for(int i = 0; i<terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken())*28);
        }

        //기간 계산
        for(int i = 0; i<privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            int date = dateToInt(st.nextToken());
            date += map.get(st.nextToken());
            if(todayInt >= date){
                arr.add(i+1);
            }
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }

    // string 날자 계산을 위해 int로 바꾸기. 년*12*28+월*28+일
    public static int dateToInt(String day){
        int ans = 0;
        String []arr = day.split("\\.");
        ans = Integer.parseInt(arr[0])*28*12+Integer.parseInt(arr[1])*28+Integer.parseInt(arr[2]);
        return ans;
    }
}
