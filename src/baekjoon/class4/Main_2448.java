package baekjoon.class4;

import java.io.*;
public class Main_2448 {
    static int N;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        int dummy = N/3;

        arr = new boolean[N][N*2-1];

        fillStar(0, N-1, N);

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N*2-1; j++){
                if(arr[i][j]) bw.write("*");
                else bw.write(" ");
            }
            bw.write("\n");
        }
        bw.close();
    }

    static void fillStar(int x, int y, int maxSZ){
        if(maxSZ == 3){
            arr[x][y] = true;
            arr[x+1][y-1] = true;
            arr[x+1][y+1] = true;
            for(int i = y-2; i<=y+2; i++){
                arr[x+2][i] = true;
            }
            return;
        }

        fillStar(x, y, maxSZ/2);
        fillStar(x+maxSZ/2, y-maxSZ/2, maxSZ/2);
        fillStar(x+maxSZ/2, y+maxSZ/2, maxSZ/2);
    }
}