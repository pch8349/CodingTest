package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_2789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        map.put("C", 0); map.put("A", 0); map.put("M", 0); map.put("B", 0);
        map.put("R", 0); map.put("I", 0); map.put("D", 0); map.put("G", 0); map.put("E", 0);

        StringBuilder sb = new StringBuilder();
        for(String s: str.split("")){
            if(!map.containsKey(s)){
                sb.append(s);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}