package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2568 {
    static int N;
    static List<int []> list;
    static List<Integer> lastNums;
    static int []arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        lastNums = new ArrayList<>();
        arr = new int[N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        Collections.sort(list, Comparator.comparing(o -> o[0]));

        lastNums.add(0);
        for(int i = 0; i<N; i++){
            int a = list.get(i)[1];
            int n = binarySearch(a);
            if(lastNums.size()==n){
                lastNums.add(a);
            } else {
                lastNums.set(n, a);
            }
            arr[i] = n;
        }

        int maxn = lastNums.size()-1;
        StringBuilder sb = new StringBuilder()
                .append(N - maxn)
                .append("\n");

        List<Integer> tmp = new ArrayList<>();
        for(int i = N - 1; i>=0; i--) {
            if (arr[i] == maxn) {
                tmp.add(i);
                maxn--;
            }
        }

        for(int i = 0; i<N; i++){
            if(!tmp.contains(i)) {
                sb.append(list.get(i)[0]).append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    static int binarySearch(int n){
        int ll = 0;
        int rr = lastNums.size();
        while(ll<rr){
            int mid = (ll+rr)/2;
            if(lastNums.get(mid)>n){
                rr = mid;
            } else {
                ll = mid + 1;
            }
        }
        return ll;
    }
}
