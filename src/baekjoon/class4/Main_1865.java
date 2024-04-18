package baekjoon.class4;

import java.io.*;
import java.util.*;

/**
 * 문제 해결에는 벨만-포드 알고리즘 필요.
 * 기본 경로는 방향이 없고, 음수 경로에는 방향이 있다.
 * 두 노드 사이에 한개 이상의 경로가 존재할 수 있으므로
 * 입력 받을 때 최소 경로만 저장하는 과정이 필요하다.
 */
public class Main_1865 {

    public static class Road {
        int end;
        int weight;

        Road(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static int N;
    public static int M;
    public static int W;
    public static ArrayList<ArrayList<Road>> list;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();

            for(int i = 0; i<N; i++){
                list.add(new ArrayList<>());
            }

            // step 1: 경로 정보 저장
            for(int i = 0; i<M+W; i++){
                st = new StringTokenizer(br.readLine());
                int startPoint = Integer.parseInt(st.nextToken())-1;
                int endPoint = Integer.parseInt(st.nextToken())-1;
                int weight = Integer.parseInt(st.nextToken());

                // 웜홀이 아닌 일반경로는 양방향 통행이 가능하므로 저장
                if(i<M) {
                    list.get(startPoint).add(new Road(endPoint, weight));
                    list.get(endPoint).add(new Road(startPoint, weight));
//                    updateWeight(startPoint, endPoint, weight);
//                    updateWeight(endPoint, startPoint, weight);
                }
                // 웜홀은 음수로 저장
                else{
                    list.get(startPoint).add(new Road(endPoint, -weight));
//                    updateWeight(startPoint, endPoint, -weight);
                }
            }

            boolean flag = false;
            for(int i = 0; i<N; i++){
                // 2. 벨만포드 알고리즘 실행. 1번 정점부터 연결된 애들
                if(bellman_ford(i)){
                    flag = true;
                    break;
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");

        }
    }
    // 벨만포드
    public static boolean bellman_ford(int startPoint){
        int totalWeight[] = new int[N];
        Arrays.fill(totalWeight, INF);
        totalWeight[startPoint] = 0;
        boolean flag = false;

        for(int k = 1; k<N; k++) {
            flag = false;

            for (int i = 0; i < N; i++) {
                for (Road road : list.get(i)) {

                    if (totalWeight[i]!=INF && road.weight + totalWeight[i] < totalWeight[road.end]) {
                        totalWeight[road.end] = road.weight + totalWeight[i];
                        flag = true;
                    }
                }
            }
            if(!flag) {
                break;
            }
        }

        if(flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    Road road = list.get(i).get(j);
                    if (totalWeight[i] != INF && road.weight + totalWeight[i] < totalWeight[road.end]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 입력받은 경로 정보에 이미 다른 도로가 있다면, 도로 값이 더 작은 놈으로 최신화한다.
    public static void updateWeight(int startPoint, int endPoint, int weight){
        boolean flag = true;
        for(int i = 0; i<list.get(startPoint).size(); i++){
            if(list.get(startPoint).get(i).end == endPoint){
                list.get(startPoint).get(i).weight = Math.min(weight, list.get(startPoint).get(i).weight);
                flag = false;
            }
        }
        if(flag) {
            list.get(startPoint).add(new Road(endPoint, weight));
        }
    }
}
