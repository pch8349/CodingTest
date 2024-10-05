package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_2096 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxAns[] = new int[3];
        int minAns[] = new int[3];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[3];
            for(int j = 0; j<3; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int imsiMaxAns[] = new int[3];
            int imsiMinAns[] = new int[3];

            for(int j = 0; j<3; j++){
                int prevMax = 0;
                int prevMin = Integer.MAX_VALUE;
                for(int k = -1; k<2; k++){
                    if(k+j<0 || k+j>2) continue;
                    prevMax = Math.max(prevMax, maxAns[k+j]);
                    prevMin = Math.min(prevMin, minAns[k+j]);
                }
                imsiMaxAns[j] = prevMax + arr[j];
                imsiMinAns[j] = prevMin + arr[j];
            }

            for(int j = 0; j<3; j++){
                maxAns[j] = imsiMaxAns[j];
                minAns[j] = imsiMinAns[j];
            }

        }

        int maxx = 0;
        int minn = Integer.MAX_VALUE;
        for(int i = 0; i<3; i++){
            maxx = Math.max(maxx, maxAns[i]);
            minn = Math.min(minn, minAns[i]);
        }

        System.out.println(maxx+" "+minn);
    }
}
