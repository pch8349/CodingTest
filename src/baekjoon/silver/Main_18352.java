package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_18352 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] loads = new ArrayList[N+1];
        int [] least = new int[N+1];

        Arrays.fill(least, Integer.MAX_VALUE);
        for(int i = 0; i<=N; i++) loads[i] = new ArrayList<>();
        least[X] = 0;

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            loads[a].add(b);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, 0});
        while(!q.isEmpty()){
            int loc = q.peek()[0];
            int val = q.poll()[1] + 1;
            for(int i : loads[loc]){
                if(least[i] > val){
                    least[i] = val;
                    q.add(new int[]{i, val});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=N; i++){
            if(least[i]==K) {
                sb.append(i).append("\n");
            }
        }
        if(sb.length()==0){
            sb.append(-1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}