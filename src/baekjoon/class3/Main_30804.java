package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }


        int ans = 1;
        int start = 0;
        int end = 1;
        int fruitInfo[][] = new int[2][2]; // 과일1 번호, 과일1 마지막위치 / 과일2 번호, 과일2 마지막위치
        fruitInfo[0][0] = S[0];

        while(end < N){

            // 과일이 아직 다 안채워졌을 때
            if(fruitInfo[1][1] == 0){

                // 과일이 이전것과 같을 때
                if(fruitInfo[0][0] == S[end]){
                    fruitInfo[0][1] = end;
                }

                // 과일이 이전것과 다를 때
                else if(fruitInfo[0][0] != S[end]){
                    fruitInfo[1][0] = S[end];
                    fruitInfo[1][1] = end;
                }
            }

            // 다음 과일이 같을 때
            else if(fruitInfo[0][0] == S[end] || fruitInfo[1][0] == S[end]){
                if(fruitInfo[0][0] == S[end]){
                    fruitInfo[0][1] = end;
                } else {
                    fruitInfo[1][1] = end;
                }
            }
            // 다음 과일이 다를 때
            else {
                int minIdx = fruitInfo[0][1] < fruitInfo[1][1]? 0 : 1;

                start = fruitInfo[minIdx][1] + 1;
                fruitInfo[minIdx][0] = S[end];
                fruitInfo[minIdx][1] = end;
            }
            ans = Math.max(ans, end-start+1);
            end++;
        }

        System.out.println(ans);
    }
}
