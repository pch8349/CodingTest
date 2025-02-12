package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_1491 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean flag = true;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                flag = false;
                break;
            }
        }
        if(flag) bw.write("Good");
        else bw.write("Bad");
        bw.flush();
        bw.close();
    }
}