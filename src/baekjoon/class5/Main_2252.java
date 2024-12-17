package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_2252 {
    static int N, M;
    static int [] frontCnt;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<= N; i++) lists.add(new ArrayList<>());
        frontCnt = new int[N + 1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists.get(a).add(b);
            frontCnt[b] += 1;
        }

        /**
         * 위상 정렬으로 모든 학생이 순서대로 세우는 경우 탐색하기
         */
        StringBuilder ans = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            if(frontCnt[i] == 0) queue.add(i);
        }

        // 위상정렬 진행
        while(!queue.isEmpty()){
            int now = queue.poll();
            ans.append(now).append(" ");
            for(int next : lists.get(now)){
                frontCnt[next] -= 1;
                if(frontCnt[next] == 0) queue.add(next);
            }
        }

        System.out.println(ans);
    }
}