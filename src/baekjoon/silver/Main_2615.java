package baekjoon.silver;
import java.io.*;
import java.util.*;
public class Main_2615 {
    static int [][]arr = new int[19][19];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i<19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<19; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int w_loc = 0;
        int l_loc= 0;
        boolean flag = false;

        // 이동은 아래, 오른쪽, 오른아래, 오른위 방향으로만 탐색
        int [][]mv = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){

                if(arr[i][j] != 0){

                    int doll = arr[i][j];

                    for (int[] mvto : mv) {
                        int x = i;
                        int y = j;
                        int cnt = 1;

                        // 정방향 탐색
                        while(true){
                            int a = x + mvto[0];
                            int b = y + mvto[1];
                            if (isOut(a, b) || arr[a][b] != doll) {
                                break;
                            } else {
                                x = a;
                                y = b;
                                cnt++;
                            }
                        }

                        // 역방향으로 봐서 6목 이상인지 탐색.
                        if(cnt == 5){
                            if(isOut(i-mvto[0], j-mvto[1])) {
                                flag = true;
                            } else {
                                if(arr[i-mvto[0]][j-mvto[1]] == doll) {
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            }
                        }
                        if (flag) {
                            w_loc = i;
                            l_loc = j;
                        }
                    }
                }
                if(flag) break;
            }
            if(flag) break;
        }

        if(flag){
            System.out.println(arr[w_loc][l_loc]);
            System.out.println((w_loc+1)+" "+(l_loc+1));
        } else {
            System.out.println(0);
        }

    }

    static boolean isOut(int n, int m){
        if(n<0 || m<0 || n>18||m>18) return true;
        else return false;
    }
}
