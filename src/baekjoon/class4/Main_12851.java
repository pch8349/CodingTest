package baekjoon.class4;

import java.awt.*;
import java.io.*;
import java.util.*;
public class Main_12851 {
    static int N, K, time, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(time+"\n"+cnt);
    }

    private static void bfs(){
        int visit[] = new int[100001];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        visit[N] = 1;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.x == K){
                if(cnt==0) time = p.y;
                if(time==p.y) cnt++;
                continue;
            }
            int arr[] = {p.x-1, p.x+1, p.x*2};
            for(int i = 0; i<3; i++){
                int next = arr[i];
                if(next<0 || next>100000) continue;
                if(visit[next] == 0 || visit[next] == p.y+1){
                    visit[next] = p.y+1;
                    queue.add(new Point(next, p.y+1));
                }
            }
        }
    }
}