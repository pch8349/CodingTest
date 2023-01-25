package Kakao_tes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cap = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int []deliveries = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            deliveries[i] = Integer.parseInt(st.nextToken());
        }
        int []pickups = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            pickups[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<int[]> del= new Stack<>();
        Stack<int[]> pick = new Stack<>();
        for(int i = 0; i<n; i++){
            if(deliveries[i] != 0) {
                del.add(new int[] {i, deliveries[i]});
            }
            if(pickups[i] != 0) {
                pick.add(new int[] {i, pickups[i]});
            }
        }

        while(!del.empty() || !pick.empty()){
            int arr[] = new int[2];
            int arr2[] = new int[2];
            while(!del.empty() && arr[1] < cap){
                if(del.peek()[1] + arr[1] <= cap){
                    arr[1] += del.peek()[1];
                    if(arr[0] == 0) arr[0] = del.peek()[0];
                    del.pop();
                }
                else {
                    int x = cap-arr[1];
                    arr[1] = cap;
                    int a = del.peek()[0], b = del.peek()[1];
                    del.pop();
                    del.add(new int[] {a, b - x});
                }
            }
            while(!pick.empty() && arr2[1] < cap){
                if(pick.peek()[1] + arr2[1] <= cap){
                    arr2[1] += pick.peek()[1];
                    if(arr2[0] == 0) arr2[0] = pick.peek()[0];
                    pick.pop();
                }
                else {
                    int x = cap-arr2[1];
                    arr2[1] = cap;
                    int a = pick.peek()[0], b = pick.peek()[1];
                    pick.pop();
                    pick.add(new int[] {a, b - x});
                }
            }
            answer += 2*(Math.max(arr[0], arr2[0])+1);
        }
        return answer;
    }
}
