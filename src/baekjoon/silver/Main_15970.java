package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_15970 {
    static int N;
    static List<Integer> [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new List[N+1];
        for(int i = 0; i<=N; i++) arr[i] = new ArrayList<>();
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b].add(a);
        }

        for(int i = 0; i<=N; i++) Collections.sort(arr[i]);

        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(arr[i].size() == 0) continue;
            ans += arr[i].get(1) - arr[i].get(0) + arr[i].get(arr[i].size()-1) - arr[i].get(arr[i].size()-2);
            for(int j = 1; j < arr[i].size()-1; j++){
                ans += Math.min(arr[i].get(j) - arr[i].get(j-1), arr[i].get(j+1) - arr[i].get(j));
            }
        }

        StringBuilder sb = new StringBuilder().append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}