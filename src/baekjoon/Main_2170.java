package baekjoon;
import java.io.*;
import java.util.*;
public class Main_2170 {
    static int N;
    static int [][]arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]){
                return o1[0] != o2[0] ? o1[0]-o2[0]:o1[1]-o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(arr[0]);
        int idx = 0;

        for(int i = 1; i<N; i++){
            if(list.get(idx)[1]>=arr[i][0]) {
                list.get(idx)[1] = Math.max(arr[i][1], list.get(idx)[1]);
            } else {
                list.add(arr[i]);
                idx++;
            }
        }

        int ans = 0;
        for(int i = 0; i<list.size(); i++){
            ans += list.get(i)[1] - list.get(i)[0];
        }
        System.out.println(ans);
    }
}
