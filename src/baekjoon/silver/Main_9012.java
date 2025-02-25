package baekjoon.silver;
import java.io.*;
import java.util.*;

public class Main_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc<T; tc++){

            Queue<Integer> queue = new LinkedList<>();

            String s = br.readLine();
            boolean flag = true;

            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) == '(') queue.add(0);
                else {
                    if(queue.isEmpty()){
                        flag = false;
                        break;
                    } else{
                        queue.poll();
                    }
                }
            }

            if(flag && queue.isEmpty()){
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
