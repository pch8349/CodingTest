package baekjoon;

import java.io.*;
import java.util.*;

public class Main_22945 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int ll = 0;
        int rr = N-1;
        int power = 0;
        while(ll<rr){
            int sum = Math.min(arr[rr], arr[ll]) * (rr - ll - 1);
            System.out.println(ll+" : "+rr+" = "+sum);
            power = Math.max(power, sum);

            if(arr[rr]<arr[ll]) {
                rr -= 1;
            } else if (arr[rr]==arr[ll]){
                if(Math.min(arr[rr-1], arr[ll]) < Math.min(arr[rr], arr[ll+1])) ll+=1;
                else rr-=1;
            } else {
                ll+=1;
            }
        }
        System.out.println(power);
    }
}
