package baekjoon.class3;
import java.io.*;
import java.util.*;
public class Main_14500 {
    static int N;
    static int M;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mv[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){

                // ㅗ 모양은 체크하지 못함
                Queue<int []> q = new LinkedList<>();
                q.add(new int[]{1, i*1000+j, -1, -1, -1, arr[i][j]});
                while(!q.isEmpty()){
                    int now[] = q.poll();
                    if(now[0] == 4){
                        ans = Math.max(ans, now[5]);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            if (visitCheck(now, mv[k][0], mv[k][1])) {
                                int a = now[now[0]] / 1000 + mv[k][0];
                                int b = now[now[0]] % 1000 + mv[k][1];
                                int newArr[] = Arrays.copyOf(now, now.length);
                                newArr[5] += arr[a][b];
                                newArr[now[0] + 1] = a * 1000 + b;
                                newArr[0] += 1;
                                q.add(newArr);
                            }
                        }
                    }
                }

                // ㅗ 모양 체크

            }
        }
        System.out.println(ans);
    }

    static boolean visitCheck(int arr[], int x1, int y1){
        int a = arr[arr[0]]/1000 + x1;
        int b = arr[arr[0]]%1000 + y1;
        if(a<0||b<0||a>=N||b>=M) return false;
        for(int i = 1; i<=arr[0]; i++){
            if(arr[i] == a*1000+b) return false;
        }
        return true;
    }
}
