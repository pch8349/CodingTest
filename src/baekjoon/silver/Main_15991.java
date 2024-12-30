package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_15991 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long arr[] = new long[100001];
        for(int i = 1; i <= 3; i++) {
            arr[i] += 1;
            arr[i+i] += 1;
        }

        for(int i = 1; i < 100001; i++){
            for(int j = 1; j <= 3; j++){
                if(i + j + j < 100001) {
                    arr[i + j + j] += arr[i];
                    arr[i+ j + j] %= 1000000009;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[n]);
        }
    }
}