package baekjoon.bronze;
import java.io.*;
import java.util.*;
public class Main_3040 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dwarf[] = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }

        int fake_dwarf[] = new int[2];
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - dwarf[i] - dwarf[j] == 100) {
                    fake_dwarf[0] = i;
                    fake_dwarf[1] = j;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(i != fake_dwarf[0] && i != fake_dwarf[1]) System.out.println(dwarf[i]);
        }
    }
}
