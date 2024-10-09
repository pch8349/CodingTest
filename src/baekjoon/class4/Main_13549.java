package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_13549 {
    static int N;
    static int K;
    static int dist[] = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 만일 2차원 배열의 두 번째 원소가 같다면, 첫번째 원소를 기준으로 K 값에 가까운 순으로 정렬한다.
                if(o1[1] == o2[1]){
                    return Integer.compare(Math.abs(o1[0]-K), Math.abs(o2[0]-K));
                }
                // 2차원 배열의 두 번째 원소를 기준으로 오름차순 정렬한다.
                return Integer.compare(o1[1], o2[1]);
            }
        });

        queue.add(new int[]{N, dist[N]});
        while(!queue.isEmpty()){
            int X = queue.peek()[0];
            int XVal = queue.poll()[1];

            if(X == K) break;

            for(int i = X; i<K*2; i*=2){
                if(i>100000) break;
                if(i == 0) break;
                if(dist[i] > XVal){
                    dist[i] = XVal;
                    queue.add(new int[]{i, XVal});
                }
            }

            if(X>0 && dist[X-1] > XVal + 1){
                dist[X-1] = XVal + 1;
                queue.add(new int[]{X-1, XVal + 1});
            }
            if(X<100000 && dist[X+1] > XVal + 1){
                dist[X+1] = XVal + 1;
                queue.add(new int[]{X+1, XVal + 1});
            }
        }

        System.out.println(dist[K]);
    }
}