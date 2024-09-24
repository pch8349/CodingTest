package baekjoon.class2;

import java.io.*;
import java.util.*;

public class Main_28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String FizzBuzz[] = new String[3];

        int lastNumLoc = 0;
        for(int i = 0; i<3; i++){
            FizzBuzz[i] = br.readLine();
            if(FizzBuzz[i].charAt(0) >= '0' && FizzBuzz[i].charAt(0) <='9'){
                lastNumLoc = i;
            }
        }

        int ansNum = 3 - lastNumLoc + Integer.parseInt(FizzBuzz[lastNumLoc]);

        String ans = "";
        if(ansNum %3 == 0 && ansNum % 5 == 0) ans = "FizzBuzz";
        else if(ansNum % 3 == 0) ans = "Fizz";
        else if(ansNum % 5 == 0) ans = "Buzz";
        else ans = String.valueOf(ansNum);

        System.out.println(ans);
    }
}
