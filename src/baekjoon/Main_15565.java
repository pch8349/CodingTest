package baekjoon;

import java.io.*;
import java.util.*;
public class Main_15565 {

    static int N;
    static int K;
    static int arr[];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = arr[0] == 1 ? 1 : 0;
        while(end<N){
            if(sum<K){
                if(end+1==N) break;
                sum+= arr[++end]==1?1:0;
            } else {
                ans = Math.min(ans, end-start+1);
                sum-=arr[start++]==1?1:0;
            }
        }
        if(ans==Integer.MAX_VALUE) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

//    static int N;
//    static int K;
//    static int []arr;
//    static int answer;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        arr = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i<N; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        answer = Integer.MAX_VALUE;
//        div();
//
//        if(answer== Integer.MAX_VALUE) answer = -1;
//        bw.write(String.valueOf(answer));
//        bw.flush();
//    }
//
//
//    static void div(){
//        int st = 0;
//        int end = N;
//        while(st<=end){
//            int sz = (st+end)/2;
//            int lionCnt = 0;
//            int sum = 0;
//            for(int i = 0; i<sz; i++) if (arr[i] == 1) lionCnt++;
//            sum = lionCnt;
//            for(int i = 1; i<=N-sz; i++) {
//                if(arr[i-1] == 1) sum -=1;
//                if(arr[i+sz-1] == 1) sum += 1;
//                lionCnt = Math.max(lionCnt, sum);
//            }
//            if(lionCnt>=K) {
//                answer = Math.min(sz, answer);
//                end = sz - 1;
//            } else {
//                st = sz + 1;
//            }
//        }
//    }
}
