package baekjoon.gold2;

import java.io.*;
import java.util.*;
public class Main_12738 {
    static int N;
    static int []A;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(A[0]);
        for(int i = 1; i<N; i++){
            if(lis.get(lis.size()-1) < A[i]){
                lis.add(A[i]);
            } else {
                int idx = binarySearch(lis, A[i]);
                lis.set(idx, A[i]);
            }
        }

        System.out.println(lis.size());
    }

    static int binarySearch(List<Integer> list, int n){
        int start = 0;
        int end = list.size() - 1;
        while(start < end) {
            int pivot = (start + end)/2;

            if(list.get(pivot) < n){
                start = pivot+1;
            } else {
                end = pivot;
            }
        }

        return start;
    }
}
