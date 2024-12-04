package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_27172 {
    static int N;
    static int []card;
    static int []point;
    static int []number;
    static final int INF = 1000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N+1];
        point = new int[N+1];
        number = new int[INF];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            number[card[i]] = i;
        }

        for(int i = 1; i <= N; i++){
            for(int k = 2; card[i] * k < INF; k++){
                if(number[card[i]*k] != 0) {
                    point[i] += 1;
                    point[number[card[i]*k]] -= 1;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(point[i]+" ");
        }
    }
}