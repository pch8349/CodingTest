package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_14500 {
    static int N;
    static int M;
    static int arr[][];
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mv[][] = {{-1, 0},{1,0},{0,-1},{0,1}};

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{1, M*i+j, -1, -1, -1, arr[i][j]});
                while(!q.isEmpty()){
                    int tmp[] = q.poll();
                    if(tmp[0] == 4) {
                        ans = Math.max(tmp[5], ans);
                        continue;
                    }

                    //2칸 채워졌을 때 ㅗ, ㅜ, ㅏ, ㅓ 모양으로 채우기(2칸 뻗은 방향으로 3칸 나가고 가운데에 하나 나가기)
                    if(tmp[0] == 2){
                        int mv_a = (2*tmp[2] - tmp[1])/M;
                        int mv_b = (2*tmp[2] - tmp[1])%M;
                        if(isValid(mv_a, mv_b, tmp)) {
                            int imsi[] = fillArray(mv_a, mv_b, tmp);
                            int a = tmp[2]/M;
                            int b = tmp[2]%M;
                            if((tmp[2] - tmp[1])/M == 0){
                                if(isValid(a+mv[0][0], b+mv[0][1], imsi)) {
                                    q.add(fillArray(a+mv[0][0], b+mv[0][1], imsi));
                                }
                                if(isValid(a+mv[1][0], b+mv[1][1], imsi)) {
                                    q.add(fillArray(a+mv[1][0], b+mv[1][1], imsi));
                                }
                            } else {
                                if(isValid(a+mv[2][0], b+mv[2][1], imsi)) {
                                    q.add(fillArray(a+mv[2][0], b+mv[2][1], imsi));
                                }
                                if(isValid(a+mv[3][0], b+mv[3][1], imsi)) {
                                    q.add(fillArray(a+mv[3][0], b+mv[3][1], imsi));
                                }
                            }
                        }
                    }

                    //ㅗ 모양 제외
                    for(int k = 0; k<4; k++){
                        int a = tmp[tmp[0]]/M + mv[k][0];
                        int b = tmp[tmp[0]]%M + mv[k][1];
                        if(isValid(a, b, tmp)) {
                            q.add(fillArray(a, b, tmp));
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static int[] fillArray(int a, int b, int tmp[]){
        int imsi[] = Arrays.copyOf(tmp, 6);
        imsi[0] += 1;
        imsi[imsi[0]] = a*M+b;
        imsi[5]+=arr[a][b];
        return imsi;
    }

    static boolean isValid(int a, int b, int tmp[]){
        if(a<0||b<0||a>=N||b>=M) return false;
        for(int i = 1; i<=tmp[0]; i++){
            if(tmp[i] == a*M+b) return false;
        }
        return true;
    }
}
