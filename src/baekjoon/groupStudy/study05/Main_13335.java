package baekjoon.groupStudy.study05;
import java.io.*;
import java.util.*;
public class Main_13335 {
    static int N, W, L;
    static int[] trucks;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<int[]> q = new LinkedList<>(); // idx, 현재 다리위 위치
        q.add(new int[]{0, 0});
        int nowWeight = trucks[0]; // 현재 다리 위 위치
        int sec = 1; // 현재 지난 시간. 다리위에 첫 트럭 올려서 1초로 초기화
        int idx = 1; // 다음으로 올라가야할 트럭 번호

        while(!q.isEmpty()){
            int plus = 1;
            if (idx<N && nowWeight+trucks[idx]>L){ // 다리의 무게 때문에 못올라가면
                nowWeight -= trucks[q.peek()[0]]; // 가장먼저 올라간 트럭을 빼줌(무게)
                plus = W - q.poll()[1]; // 위치도 끝까지 빼줌
            }

            int n = q.size();
            for(int i=0; i<n; i++){
                q.add(new int[]{q.peek()[0], q.poll()[1]+plus});
            }

            sec += plus;

            if(!q.isEmpty() && q.peek()[1] >= W) nowWeight -= trucks[q.poll()[0]]; // 혹시 이동시켰을 때 다리 밖으로 나가면 빼줌

            if(idx<N && nowWeight+trucks[idx]<=L) { // 신규 트럭 올리기
                q.add(new int[]{idx, 0});
                nowWeight += trucks[idx++];
            }
        }
        System.out.println(sec);
    }
}