package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int []load = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int []gasFee = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long ans = 0;
        long minFee = gasFee[0];
        long needGasDistance = 0;
        for(int i = 0; i<N-1; i++){
            if(minFee > gasFee[i]){
                ans += needGasDistance * minFee;
                needGasDistance = 0;
                minFee = gasFee[i];
            }
            needGasDistance += load[i];
        }
        ans += needGasDistance * minFee;
        System.out.println(ans);
    }
}