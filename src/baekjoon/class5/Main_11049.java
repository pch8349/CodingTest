package baekjoon.class5;
import java.io.*;
import java.util.*;
public class Main_11049 {

    static int N;
    static int[][] arr;
    static Node [][]dpArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        dpArr = new Node [N][N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N-1; i++){
            dpArr[i][i+1] = new Node(arr[i][0], arr[i+1][1], (long) arr[i][0] *arr[i][1]*arr[i+1][1]);
        }

        long ans = dp(0, N-1).v;

        System.out.println(ans);
    }

    private static Node dp(int st, int end){
        if(dpArr[st][end] != null){
            return dpArr[st][end];
        }
        Node x = dp(st, end - 1);
        Node y = dp(st + 1, end);
        long xSum = x.v + (long) x.x * x.y * arr[end][1];
        long ySum = y.v + (long) y.x  * y.y * arr[st][0];

        if(xSum < ySum){
            dpArr[st][end] = new Node(x.x, arr[end][1], xSum);
            return dpArr[st][end];
        } else {
            dpArr[st][end] = new Node(arr[st][0], y.y, ySum);
            return dpArr[st][end];
        }
    }

    private static class Node{
        public int x;
        public int y;
        public long v;
        public Node(int x, int y, long v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}