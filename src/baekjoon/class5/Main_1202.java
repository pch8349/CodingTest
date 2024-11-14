package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_1202 {
    static int N, K;
    static int [][]jewel;
    static int []bag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewel = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0]-o2[0];
            }
        }); // 무게는 오름차순, 가격은 내림차순 정렬.

        bag = new int[K];
        for(int i = 0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        long ans = 0;
        for(int i = 0, j = 0; i<K; i++){
            while(j < N && jewel[j][0] <= bag[i]){
                queue.add(jewel[j++][1]);
            }
            if(!queue.isEmpty()){
                ans+=queue.poll();
            }
        }

        System.out.println(ans);
    }
}
