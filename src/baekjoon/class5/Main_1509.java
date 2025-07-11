package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = S.length();

        int[] dp = new int[N+1]; // dp 배열
        List<Integer>[] list = new List[N+1]; // 각 문자열 시작 위치에서 발생하는 팰린드롬 길이 저장 배열
        for(int i=0; i<=N; i++) dp[i] = i; // dp 배열 초기화(일단 모두 1개로 쪼갠다 가정)
        for(int i=0; i<=N; i++) list[i] = new ArrayList<>();

        // 각 위치에서 펠린드롬 수 전부 구하기
        for(int i=0; i<=N; i++){
            for(int j=0; j<N-i && j<=i; j++){ // 가운데 하나 기준으로 찾을때
                if(S.charAt(i-j) == S.charAt(i+j)){
                    list[i-j].add(j*2+1);
                } else break;
            }
            if(i<N-1 && S.charAt(i) ==S.charAt(i+1)){ // 가운데 두개 기준으로 찾을 때
                for(int j=0; j<N-i-1 && j<=i; j++){
                    if(S.charAt(i-j) == S.charAt(i+j+1)){
                        list[i-j].add(j*2+2);
                    } else break;
                }
            }

        }

        // DP 채우기
        for(int i=0; i<=N; i++){
            for(int j : list[i]){
                if(i+j<=N) {
                    dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}