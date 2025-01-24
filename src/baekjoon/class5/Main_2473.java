package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_2473 {
    static int N;
    static Long []liquid;
    static Long []ans = new Long[3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        liquid = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);

        long closist = Long.MAX_VALUE;

        for(int i = 0; i<N-2; i++){
            for(int j = i+1; j<N-1; j++){

                int start = j+1;
                int end = N-1;
                long target = liquid[i]+liquid[j];

                while(start<=end){
                    int pivot = (start + end)/2;

                    if (Math.abs(target + liquid[pivot]) < closist) {
                        closist = Math.abs(target + liquid[pivot]);
                        ans[0] = liquid[i]; ans[1] = liquid[j]; ans[2] = liquid[pivot];
                    }

                    if(liquid[pivot]+target == 0){
                        ans[0] = liquid[i]; ans[1] = liquid[j]; ans[2] = liquid[pivot];
                        break;
                    } else if(liquid[pivot]+target > 0){
                        end = pivot-1;
                    } else {
                        start = pivot+1;
                    }
                }
            }
        }

        bw.write(String.valueOf(ans[0] + " " + ans[1] + " " + ans[2]));
        bw.flush();
        bw.close();
    }
}