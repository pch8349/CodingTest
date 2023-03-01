package baekjoon;

import java.util.*;
import java.io.*;
public class Main_9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int arr1[] = new int[s1.length()];
        int arr2[] = new int[s2.length()];

        for(int i =0; i<arr1.length; i++){
            arr1[i] = s1.charAt(i) - 'A';
        }
        for(int i = 0; i<arr2.length; i++) {
            arr2[i] = s2.charAt(i) -'A';
        }

        int LCS[][] = new int[arr1.length+1][arr2.length+1];

        for(int i = 1; i<=arr1.length; i++){
            for(int j = 1; j<=arr2.length; j++) {
                if(arr1[i-1] == arr2[j-1]) LCS[i][j] = LCS[i-1][j-1] + 1;
                else LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
            }
        }

        System.out.println(LCS[arr1.length][arr2.length]);
    }
}
