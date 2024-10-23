package baekjoon.sprout;

import java.io.*;
import java.util.*;

public class Main_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();

        while(true){
            String s = br.readLine();
            if(s == null) break;
            list.add(s);
        }

        for(String s : list) bw.write(s+"\n");
        bw.close();
    }
}
