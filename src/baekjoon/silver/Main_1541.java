package baekjoon.silver;

import java.io.*;
import java.util.*;
public class Main_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String []numArr = br.readLine().split("-");
        int ans = 0;

        // 람다식
        ans = Arrays.stream(Arrays.stream(numArr[0].split("\\+")).mapToInt(Integer::parseInt).toArray()).sum();

        for(int i = 1; i<numArr.length; i++){
            ans -= Arrays.stream(Arrays.stream(numArr[i].split("\\+")).mapToInt(Integer::parseInt).toArray()).sum();
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}