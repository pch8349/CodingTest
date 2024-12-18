package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_2342 {
    static int [][][]dp;
    static int []stepInfo;
    static int stepLen;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        stepLen = st.countTokens() - 1;
        dp = new int[stepLen][5][5];
        stepInfo = new int[stepLen];

        for(int i = 0; i < stepLen; i++) stepInfo[i] = Integer.parseInt(st.nextToken());

        System.out.println(search(0, 0, 0));
    }

    // dp[i][j][k]를 채워줄 재귀함수. i : idx, j : 왼발 밟은데, k : 오른발 밟은데
    static int search(int idx, int l, int r){
        // 발판을 모두 밟았을 때
        if(idx == stepLen) return 0;

        // 이미 밟은 발판이면
        if(dp[idx][l][r] != 0) return dp[idx][l][r];

        int next = stepInfo[idx];

        int next_l = search(idx + 1, next, r) + powerCalc(l, next);
        int next_r = search(idx + 1, l, next) + powerCalc(r, next);

        dp[idx][l][r] = Math.min(next_l, next_r);

        return dp[idx][l][r];
    }
    static int powerCalc(int before, int after){
        int gap = Math.abs(before - after);
        if(before == after) return 1;
        else if (before == 0) return 2;
        else if(gap == 1 || gap == 3) return 3;
        else return 4;
    }
}