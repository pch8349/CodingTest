package baekjoon.class5;

import java.io.*;
import java.util.*;

public class Main_16724 {

    static int N, M;
    static String[][] arr;
    static int [][] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        parents = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            arr[i] = line.split("");
            for (int j = 0; j < M; j++) {
                parents[i][j] = -1;
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                parents[i][j] = i*M + j;
//                System.out.print(parents[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(parents[i][j] == -1){
                    int p = i * M + j;
                    int x = i;
                    int y = j;
                    while(true){
                        // 방문 아직 안했으면
                        if(parents[x][y] == -1) {
                            parents[x][y] = p;
                            switch(arr[x][y]){
                                case "D" :
                                    x+=1;
                                    break;
                                case "U" :
                                    x-=1;
                                    break;
                                case "R" :
                                    y+=1;
                                    break;
                                case "L" :
                                    y-=1;
                                    break;
                            }
                        }

                        // 방문 했고 같으면
                        else if(parents[x][y] == p){
                            break;
                        }

                        // 방문 헀고 다르면
                        else {
                            unionParent(p, x*M+y);
                            break;
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<N*M; i++) {
            set.add(parents[i/M][i%M]);
        }
        System.out.println(set.size());
    }

    static int getParent(int x){
        if(parents[x/M][x%M] == x) return x;
        else return parents[x/M][x%M] = getParent(parents[x/M][x%M]);
    }

    static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a < b) parents[b/M][b%M] = a;
        else parents[a/M][a%M] = b;
    }
}