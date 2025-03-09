package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int lastValue = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("push")) {
                lastValue = Integer.parseInt(st.nextToken());
                queue.offer(lastValue);
            } else {
                if (command.equals("size")) {
                    sb.append(queue.size());
                } else if (command.equals("empty")) {
                    String s = queue.isEmpty() ? "1" : "0";
                    sb.append(s);
                } else {
                    if (queue.isEmpty()) {
                        sb.append("-1");
                    } else if (command.equals("pop")) {
                        sb.append(queue.poll());
                    } else if (command.equals("front")) {
                        sb.append(queue.peek());
                    } else if (command.equals("back")) {
                        sb.append(lastValue);
                    }
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}