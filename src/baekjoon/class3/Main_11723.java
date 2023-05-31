package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_11723 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[21];
        int for_fill[] = new int[21];
        for(int i = 0; i<21; i++){
            for_fill[i] = i;
        }
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("all")){
                arr = Arrays.copyOf(for_fill, 21);
            } else if (s.equals("empty")) {
                Arrays.fill(arr, 0);
            } else {
                int n = Integer.parseInt(st.nextToken());
                if (s.equals("add")) {
                    arr[n] = 1;
                } else if (s.equals("check")) {
                    if (arr[n] == 0) bw.write("0\n");
                    else bw.write("1\n");
                } else if (s.equals("remove")) {
                    arr[n] = 0;
                } else if (s.equals("toggle")){
                    if(arr[n] == 0) arr[n] = 1;
                    else arr[n] = 0;
                }
            }
        }
        bw.flush();
    }
}
