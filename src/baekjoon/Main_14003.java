package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14003 {
    static int N;
    static int []arr;
    static List<Integer> sequence;
    static int[] series;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sequence = new ArrayList<>();
        sequence.add(Integer.MIN_VALUE);
        series = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N;i++){
            int n = binarySearch(arr[i], 0, sequence.size());
            if(sequence.size()==n) {
                sequence.add(arr[i]);
            } else {
                sequence.set(n, arr[i]);
            }
            series[i] = n;
        }
        int maxn = sequence.size()-1;
        int tmp = maxn;
        int []ans = new int[maxn];
        for(int i = N-1; i>=0; i--){
            if(tmp == series[i]) {
                ans[--tmp] = arr[i];
            }
        }
        System.out.println(maxn);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }

    static int binarySearch(int n, int ll, int rr){
        while (ll<rr) {
            int pivot = (ll + rr) / 2;
            if (sequence.get(pivot) < n) {
                ll = pivot+1;
            } else {
                rr = pivot;
            }
        }
        return ll;
    }
}
