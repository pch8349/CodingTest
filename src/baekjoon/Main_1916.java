package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        List<List<Pair>> list = new ArrayList<>();
        int distance[] = new int[N];

        for(int i = 0; i<N; i++) {
            list.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a-1).add(new Pair(b-1, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        distance[start] = 0;

        while(!pq.isEmpty()){
            int now = pq.peek().x;
            int dis = pq.poll().y;
//            System.out.println("어디서 : " + now + "거리는 : " + dis);
            if(distance[now]<dis) continue;
            for(int i = 0; i<list.get(now).size(); i++) {
                Pair pair = list.get(now).get(i);
                if(distance[pair.x] > dis + pair.y) {
//                    System.out.println("좌표 : " + pair.x + " , 거리 : "+(dis+pair.y));
                    distance[pair.x] = dis + pair.y;
                    pq.add(new Pair(pair.x, dis + pair.y));
                }
            }
        }
        System.out.println(distance[end]);
    }

    static class Pair implements Comparable<Pair> {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(final Pair o) {
            if(y == o.y) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
    }
}
