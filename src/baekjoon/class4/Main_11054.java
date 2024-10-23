package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_11054 {
    static int N;
    static int A[];
    static List<int[]> lisList = new ArrayList<>();
    static List<int[]> ldsList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i <N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        lis.add(A[0]);
        lisList.add(new int[]{A[0], 0});
        for(int i = 1; i<N; i++){
            if(lis.get(lis.size()-1) < A[i]){
                lis.add(A[i]);
                lisList.add(new int[]{A[i], i});
            } else {
                int idx = binarySearch(lis, A[i]);
                lis.set(idx, A[i]);
            }
        }

        List<Integer> lds = new ArrayList<>();
        lds.add(A[N-1]);
        ldsList.add(new int[]{A[N-1], N-1});
        for(int i = N-2; i>=0; i--){
            if(lds.get(lds.size()-1) < A[i]){
                lds.add(A[i]);
                ldsList.add(new int[]{A[i], i});
            } else {
                int idx = binarySearch(lds, A[i]);
                lds.set(idx, A[i]);
            }
        }

        int ans = 1;
        for(int i = 0; i<lisList.size(); i++){
            for(int j = 0; j<ldsList.size(); j++){

                if(lisList.get(i)[1]<ldsList.get(j)[1]){

                    if(lisList.get(i)[0] == ldsList.get(j)[0]){
                        ans = Math.max(ans, i+j+1);
                    }
                    else {
                        ans = Math.max(ans, i+j+2);
                    }

                }
            }
        }
        System.out.println(ans);
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