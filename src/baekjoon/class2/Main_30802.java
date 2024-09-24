package baekjoon.class2;

import java.io.*;
import java.util.*;
public class Main_30802 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, T, P;
        int tSize[] = new int[6];

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<6;i++){
            tSize[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int tAns = 0;
        int pAns = 0;
        int pCrumbAns = 0;
        for(int i : tSize){
            tAns += i/T + 1;
            if(i%T == 0) tAns -= 1;
        }
        pAns = N/P;
        pCrumbAns = N%P;

        System.out.println(tAns + "\n" + pAns + " " + pCrumbAns);
    }
}
