package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int arr [] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ll = 0;
        int rr = 0;
        int sum = 0;
        int minn = Integer.MAX_VALUE;
        int cnt = 0;
        while(true){
            if(sum<S) {
                if(rr>=N) break;
                cnt++;
                sum += arr[rr++];
                System.out.println("더했음 : "+ sum);
            }
            else {
                minn = Math.min(minn, cnt);
                cnt--;
                sum -= arr[ll++];
            }
        }
        if(minn==Integer.MAX_VALUE) minn = 0;
        System.out.println(minn);
    }
}
