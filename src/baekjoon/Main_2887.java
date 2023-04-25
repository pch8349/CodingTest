package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2887 {
    static int N;
    static List<Planet> planets = new ArrayList<>();
    static List<Node> list = new ArrayList<>();
    static int []set;
    static double ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        set = new int[N];
        for(int i = 0; i<N; i++){
            set[i] = i;
        }

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = i;
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(idx, x, y ,z));
        }

        planets.sort(((o1, o2) -> o1.x-o2.x));
        for(int i = 1; i<N; i++) {
            int x = planets.get(i).idx;
            int y = planets.get(i - 1).idx;
            int val = planets.get(i).x - planets.get(i - 1).x;
            list.add(new Node(Math.min(x, y), Math.max(x, y), val));
        }

        planets.sort(((o1, o2) -> o1.y-o2.y));
        for(int i = 1; i<N; i++) {
            int x = planets.get(i).idx;
            int y = planets.get(i - 1).idx;
            int val = planets.get(i).y - planets.get(i - 1).y;
            list.add(new Node(Math.min(x, y), Math.max(x, y), val));
        }

        planets.sort(((o1, o2) -> o1.z-o2.z));
        for(int i = 1; i<N; i++) {
            int x = planets.get(i).idx;
            int y = planets.get(i - 1).idx;
            int val = planets.get(i).z - planets.get(i - 1).z;
            list.add(new Node(Math.min(x, y), Math.max(x, y), val));
        }

        Collections.sort(list);

        for(int i = 0; i<list.size(); i++){
            if(!find(list.get(i).x, list.get(i).y)){
                ans += list.get(i).val;
                unionParent(list.get(i).x, list.get(i).y);
            }
        }

        System.out.printf("%.0f", ans);
    }

    static boolean find(int x, int y){
        x = getParent(x);
        y = getParent(y);
        if(x==y) return true;
        else return false;
    }

    static int getParent(int x){
        if(set[x] == x) return x;
        return set[x] = getParent(set[x]);
    }

    static void unionParent(int x, int y){
        x = getParent(x);
        y = getParent(y);
        if(x<y) set[y] = x;
        else set[x] = y;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int val;
        Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }

    static class Planet {
        int idx;
        int x;
        int y;
        int z;
        Planet(int idx, int x, int y, int z){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
