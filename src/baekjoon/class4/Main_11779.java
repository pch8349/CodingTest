package baekjoon.class4;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main_11779 {
    static int N, M, A, B;
    static List<Point> []list;
    static int cost[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        list = new List[N+1];

        for(int i = 0; i<=N; i++){
            list[i] = new ArrayList<>();
            cost[i] = 999999999;
        }

        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Point(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dijk();

    }

    static void dijk(){
        Queue<Way> queue = new PriorityQueue<>(new Comparator<Way>() {
            @Override
            public int compare(Way o1, Way o2) {
                return o1.cost - o2.cost;
            }
        });

        cost[A] = 0;
        queue.add(new Way(A, 0, new ArrayList<>(Arrays.asList(A))));
        while(!queue.isEmpty()){
            int nowCost = queue.peek().cost;
            int nowLoc = queue.peek().x;
            List<Integer> nowWay = queue.poll().way;

            if(nowLoc == B){
                System.out.println(cost[B]);
                System.out.println(nowWay.size());
                for(int i :nowWay) System.out.print(i+" ");
                return;
            }

            for(int i = 0; i<list[nowLoc].size(); i++){
                if(nowCost + list[nowLoc].get(i).y < cost[list[nowLoc].get(i).x]){
                    cost[list[nowLoc].get(i).x] = nowCost + list[nowLoc].get(i).y;
                    nowWay.add(list[nowLoc].get(i).x);

                    queue.add(new Way(list[nowLoc].get(i).x, cost[list[nowLoc].get(i).x], new ArrayList<>(nowWay)));

                    nowWay.remove(nowWay.size()-1);
                }
            }
        }
    }

    private static class Way{
        int x;
        int cost;
        List<Integer> way;

        Way(int x, int cost, List<Integer> way){
            this.x = x;
            this.cost = cost;
            this.way = way;
        }
    }
}