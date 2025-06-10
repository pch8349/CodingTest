package baekjoon.groupStudy.study01;
import java.io.*;
import java.util.*;
public class Main_1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        for(int i = 0; i<N; i++){
            String s = br.readLine();
            rgb[i] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] ansArr = new int[N][3];
        ansArr[0][0] = rgb[0][0];
        ansArr[0][1] = rgb[0][1];
        ansArr[0][2] = rgb[0][2];

        for(int i = 1; i<N; i++){
            for(int j = 0; j<3; j++){
                ansArr[i][j] = rgb[i][j] + Math.min(ansArr[i-1][(j+1)%3], ansArr[i-1][(j+2)%3]);
            }
        }

        System.out.println(Math.min(ansArr[N-1][0], Math.min(ansArr[N-1][1], ansArr[N-1][2])));
    }
}
