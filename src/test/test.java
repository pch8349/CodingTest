package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[3]);
        System.out.println(arr.get(0)[0]);
        arr.get(0)[0]++;

        System.out.println(arr.get(0)[0]);

    }
}
