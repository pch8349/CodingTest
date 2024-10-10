package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_15686 {
    static int N;
    static int M;
    static int map[][];
    static int dist[][];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 살아남을 치킨집 수

        // 0 빈칸, 1 집, 2 치킨집
        map = new int[N][N];
        List<Coordinate> house = new ArrayList<>();
        List<Coordinate> chicken = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) house.add(new Coordinate(i, j));
                if(map[i][j] == 2) chicken.add(new Coordinate(i, j));
            }
        }

        // 집과 치킨집 사이 거리를 모두 구한다. 2N(<50) * M(<13) = 100 * 13 = 1300
        dist = new int[house.size()][chicken.size()];
        for(int i = 0; i<house.size(); i++){
            for(int j = 0; j<chicken.size(); j++){
                dist[i][j] = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
            }
        }

        // 최대한 치킨집을 살렸을 때 최소거리가 나오는 값을 찾는다. nCm
        ans = Integer.MAX_VALUE;
        comb(new ArrayList<>(), 0);
        System.out.println(ans);
    }

    static void comb(List<Integer> survive, int pivot){
        if(survive.size() == M){
            int nowMinDist = 0;
            for(int i = 0; i<dist.length; i++){
                int oneMinDist = Integer.MAX_VALUE;
                for(int j = 0; j<M; j++){
                    oneMinDist = Math.min(oneMinDist, dist[i][survive.get(j)]);
                }
                nowMinDist += oneMinDist;
            }
            ans = Math.min(ans, nowMinDist);
            return;
        }
        for(int i = pivot; i<dist[0].length; i++){
            survive.add(i);
            comb(survive, i + 1);
            survive.remove(survive.size()-1);
        }
    }

}

class Coordinate{
    int x;
    int y;
    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

}