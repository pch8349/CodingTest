package baekjoon.class5;
import java.io.*;
public class Main_10775 {
    static int G, P;
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parents = new int[G+1];

        for(int i = 0; i<=G; i++) parents[i] = i;
        int ans = 0;
        for(int i = 0; i < P; i++){
            int a = Integer.parseInt(br.readLine());
            if(findParent(a) == -1){
                break;
            }
            ans++;
        }

        System.out.println(ans);
    }

    static int findParent(int a){
        if(parents[a] == 0) return -1;
        else if(parents[a] == a) return parents[a] = a - 1;
        else return parents[a] = findParent(parents[a]);
    }
}