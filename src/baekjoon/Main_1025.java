package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1025 {
    static int N;
    static int M;
    static int [][]arr;
    static int answer = -1;
    static Map<Integer, Integer> multi = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i*i<1000000000; i++) {
            multi.put(i*i, i);
        }

        for(int x = 0; x<N; x++){
            for(int y = 0; y<M; y++){
                // 맵 전체 찾기

                for(int i = 1; i<=M; i++){
                    int sum = 0;
                    int positive_y = y;
                    int negative_y = y;
                    while(positive_y<M){
                        sum = sum*10 + arr[x][positive_y];
                        if(multi.containsKey(sum)){
                            answer = Math.max(sum, answer);
                        }
                        positive_y += i;
                    }
                    sum = 0;
                    while(negative_y>=0){
                        sum = sum*10 + arr[x][negative_y];
                        if(multi.containsKey(sum)){
                            answer = Math.max(sum, answer);
                        }
                        negative_y -= i;
                    }
                }
                for(int i = 1; i<=N; i++){
                    for(int j = 0; j<=M; j++){
                        int sum = 0;
                        int tmp_x = x;
                        int tmp_y = y;
                        while(tmp_x<N&&tmp_y<M&&tmp_x>=0&&tmp_y>=0){
                            sum = sum*10 + arr[tmp_x][tmp_y];
                            if(multi.containsKey(sum)){
                                answer = Math.max(sum, answer);
                            }
                            tmp_x += i;
                            tmp_y += j;
                        }
                        sum = 0;
                        tmp_x = x;
                        tmp_y = y;
                        while(tmp_x<N&&tmp_y<M&&tmp_x>=0&&tmp_y>=0){
                            sum = sum*10 + arr[tmp_x][tmp_y];
                            if(multi.containsKey(sum)){
                                answer = Math.max(sum, answer);
                            }
                            tmp_x -= i;
                            tmp_y += j;
                        }
                        sum = 0;
                        tmp_x = x;
                        tmp_y = y;
                        while(tmp_x<N&&tmp_y<M&&tmp_x>=0&&tmp_y>=0){
                            sum = sum*10 + arr[tmp_x][tmp_y];
                            if(multi.containsKey(sum)){
                                answer = Math.max(sum, answer);
                            }
                            tmp_x += i;
                            tmp_y -= j;
                        }
                        sum = 0;
                        tmp_x = x;
                        tmp_y = y;
                        while(tmp_x<N&&tmp_y<M&&tmp_x>=0&&tmp_y>=0){
                            sum = sum*10 + arr[tmp_x][tmp_y];
                            if(multi.containsKey(sum)){
                                answer = Math.max(sum, answer);
                            }
                            tmp_x -= i;
                            tmp_y -= j;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
