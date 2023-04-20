package baekjoon;

import java.io.*;
import java.util.*;

public class Main_5052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            String answer = "YES";
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for(int i = 0; i<N; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);

            for(int i = 0; i<N-1; i++){
                if(arr[i+1].startsWith(arr[i])){
                    answer = "NO";
                }
            }
            System.out.println(answer);
        }
    }
}
