package baekjoon.class1;

import java.io.*;
import java.util.*;

public class Main_31403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int ansInt = A + B - C;

        String ansString = String.valueOf(A) + String.valueOf(B);
        int ansSt = Integer.parseInt(ansString) - C;

        System.out.println(ansInt);
        System.out.println(ansSt);
    }
}
