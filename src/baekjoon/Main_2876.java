package baekjoon;

import java.util.*;
import java.io.*;

public class Main_2876 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int grade[] = new int[6];
        int straight[] = new int[6];

        int a = 0;
        int b = 0;
        for(int i = 0; i<N; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if(a == x || b == x) straight[x]++;
            else {
                grade[arr[i][0]] = Math.max(grade[arr[i][0]], straight[arr[i][0]]);
                straight[arr[i][0]] = 1;

            }
            if(straight[arr[i][1]]>0) straight[arr[i][1]]++;
            else {
                grade[arr[i][1]] = Math.max(grade[arr[i][1]], straight[arr[i][1]]);
                straight[arr[i][1]] = 1;
            }
        }
        int maxn = 0;
        int maxIndex = 0;
        for(int i = 5; i>0; i--){
            if(maxn<grade[i]) {
                maxn = grade[i];
                maxIndex = i;
            }
        }

        System.out.println(maxn +" "+ maxIndex);
    }

}
