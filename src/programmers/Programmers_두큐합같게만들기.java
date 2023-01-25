package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Programmers_두큐합같게만들기 {
    public static int[][] mv = {{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean [][] check;
    public static int [][] map;
    public static int [] aria = new int[27];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];
        for(int i = 0; i<n; i++){
            arr[i] = br.readLine();
        }
        System.out.println(solution(arr));
    }

    public static int solution(String[] maps) {
        int answer = 0;
        Map<Character, Integer> abc = new HashMap<>();

        check = new boolean[maps.length][maps[0].length()];
        map = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != '.') map[i][j] = maps[i].charAt(j) - 'A' + 1;
                else map[i][j] = 0;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        bfs();
        for(int i = 0; i<aria.length; i++){
            answer = Math.max(answer, aria[i]);
        }
        return answer;
    }

    public static void bfs(){
        Queue<int []> q = new LinkedList<>();
        Queue<int []> toChange = new LinkedList<>();
        ArrayList<int[]> arr = new ArrayList<>();
        int arr_index = 0;

        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[i].length;j++){
                if(map[i][j]>0 && !check[i][j]){
                    arr.add(new int[27]);
                    arr.get(arr_index)[map[i][j]]++;
                    q.offer(new int []{i, j});
                    toChange.offer(new int[]{i, j});
                    check[i][j] = true;
                    while(!q.isEmpty()){
                        int a = q.peek()[0];
                        int b = q.poll()[1];
                        for(int k = 0; k<4; k++){
                            int x = a + mv[k][0];
                            int y = b + mv[k][1];
                            if(x<0 || y<0 || x>=map.length || y>=map[i].length || check[x][y] || map[x][y]==0) continue;
                            arr.get(arr_index)[map[x][y]]+=1;
                            toChange.offer(new int[]{x, y});
                            q.offer(new int[]{x, y});
                            check[x][y] = true;
                        }
                    }
                    for(int ll = 0; ll<27; ll++) System.out.print(arr.get(arr_index)[ll]+" ");
                    System.out.println();

                    int maxn = 0;
                    int max_loc = 0;
                    for(int ll = 0; ll<27; ll++){
                        if(maxn<=arr.get(arr_index)[ll]){
                            maxn = arr.get(arr_index)[ll];
                            max_loc = ll;
                        }
                    }

                    while(!toChange.isEmpty()){
                        int x = toChange.peek()[0];
                        int y = toChange.poll()[1];
                        if(arr.get(arr_index)[map[x][y]] == maxn) {
                            aria[map[x][y]]++;
                        }
                        else {
                            aria[max_loc]++;
                        }
                    }

                    arr_index++;


                }
            }
        }
    }

}
