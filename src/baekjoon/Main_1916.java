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

        for(int i = 0; i<N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a-1).add(new Pair(b-1, c));
            list.get(b-1).add(new Pair(a-1, c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();



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
            if(x == o.x) return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    }
}
