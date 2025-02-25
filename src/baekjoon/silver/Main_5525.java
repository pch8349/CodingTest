package baekjoon.silver;
import java.io.*;
public class Main_5525 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()) * 2 + 1;
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int []arr = new int[M];
        for(int i = 0; i<M; i++){
            if(S.charAt(i) == 'O') arr[i] = 0;
            else arr[i] = 1;
        }

        int ans = 0;
        int collectLen = 0; // 올바른 문자열 길이를 체크하는놈

        for(int i = 0; i<M; i++){
            // 교대 문자열이 아니면 그 위치부터 다시 카운트 시작
            if(!isRight(collectLen, arr[i])){

                if(collectLen>=N){ // 찾은문자열 길이가 교대 문자열보다 길면
                    ans += (collectLen-N)/2+1; // 찾은 문자열 안에서 교대문자열 몇개인지 파악
                }

                if(arr[i] == 1) collectLen = 1; // 시작이 1부터면 카운트 1 추가
                else collectLen = 0;
            }
            else {
                collectLen++;
            }
        }

        if(collectLen>=N){
            ans += (collectLen-N)/2+1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static boolean isRight(int loc, int N){
        if(loc%2 == 0 && N==1 || loc%2 == 1 && N==0) return true;
        else return false;
    }
}