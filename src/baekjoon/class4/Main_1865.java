package baekjoon.class4;

import java.io.*;
import java.util.*;
public class Main_1865 {

    public static class Road {
        int end;
        int weight;

        Road(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N;
        int M;
        int W;
        ArrayList<ArrayList<Road>> list = new ArrayList<>();
        int INF = Integer.MAX_VALUE;

        for(int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            for(int i = 0; i<N; i++){
                list.add(new ArrayList<>());
            }

            for(int i = 0; i<M+W; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(i<M){
                    list.get(a).add(new Road(b, c));
                    list.get(b).add(new Road(a, c));
                }
                else {
                    list.get(a).add(new Road(b, c));
                }
            }

        }
    }



}
