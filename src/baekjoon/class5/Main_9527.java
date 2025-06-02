package baekjoon.class5;

import java.io.*;
import java.util.*;
public class Main_9527 {
    static long[] arr = new long[55]; // 10^16 의 2진수 길이는 54이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken())-1;
        long B = Long.parseLong(st.nextToken());

        for(int i = 1; i<arr.length; i++) arr[i] = arr[i-1] * 2 + (1L << (i - 1));

        List<Integer> ABinary = convertToBinary(A);
        List<Integer> BBinary = convertToBinary(B);
        long aCnt = oneSum(ABinary);
        long bCnt = oneSum(BBinary);

        System.out.println(bCnt - aCnt);
    }

    private static long oneSum(List<Integer> list){
        long sum = 0;
        int oneCnt = 0;

        for(int i = list.size()-1; i>=0; i--){
            if(list.get(i) == 1){
                sum += arr[i] + 1 + oneCnt * (1L << i);
                oneCnt++;
            }
        }

        return sum;
    }

    // 2진수 변환값이 역방향으로 저장됨
    static List<Integer> convertToBinary(long n){
        List<Integer> list = new ArrayList<>();
        while(true){
            if(n<2) {
                list.add((int) n);
                break;
            }
            else {
                list.add((int) (n%2));
                n/=2;
            }
        }
        return list;
    }
}