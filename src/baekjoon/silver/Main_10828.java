package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> q = new Stack<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")){
                q.push(Integer.parseInt(st.nextToken()));
            } else if(s.equals("pop")){
                if(q.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.pop()).append("\n");
                }
            } else if(s.equals("size")){
                sb.append(q.size()).append("\n");
            } else if(s.equals("empty")){
                sb.append(q.isEmpty() ? "1" : "0").append("\n");
            } else if(s.equals("top")){
                if(q.isEmpty()){
                    sb.append("-1").append("\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}