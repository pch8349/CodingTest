package baekjoon.groupStudy.study0710;
import java.io.*;
import java.util.*;
public class Main_1041 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long oneMax = 0;
        long oneMin = 9999;
        long twoMin = 9999;
        long threeMin = 9999;

        // 1개 최소, 최대값 찾기
        for(int i : arr){
            oneMin = Math.min(oneMin, i);
            oneMax = Math.max(oneMax, i);
        }

        // 2개 최소값 찾기
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(i==1&&j==4||i==0&&j==5||i==2&&j==3) continue;
                twoMin = Math.min(twoMin, arr[i]+arr[j]);
            }
        }

        // 3개 최소값 찾기
        int[] threeArr= {123, 124, 135, 145, 236, 246, 356, 456};
        for(int i : threeArr){
            threeMin = Math.min(threeMin, arr[i/100-1]+arr[i%100/10-1]+arr[i%10-1]);
        }

        long ans = 0;
        // N이 1이면 최대값 빼고 더해 출력
        if(N==1) {
            for(int i:arr)ans+=i;
            ans -= oneMax;
        } else{
            ans += threeMin*4; // 위의 네 꼭지점 더함
            ans += twoMin*(N-2)*4; // 위의 네 모서리 더하기
            ans += twoMin*(N-1)*4; // 옆면 네 모서리 더하기
            ans += oneMin*(N-2)*(N-2); // 윗면 더하기
            ans += oneMin*(N-2)*(N-1)*4; // 옆 네 면 더하기
        }

        System.out.println(ans);
    }
}