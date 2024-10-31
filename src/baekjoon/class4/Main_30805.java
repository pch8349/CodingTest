package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_30805 {
    static int N, M;
    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();
    static List<Integer> seq = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        sequence(0, 0);

        System.out.println(seq.size());
        for(int i : seq) System.out.print(i+" ");
    }

    static void sequence(int idx, int jdx){
        int maxA = 0, maxB = 0, maxAloc = 0, maxBloc = 0;

        if(idx>=A.size()||jdx>=B.size()) return;

        for(int i = idx; i<A.size(); i++){
            if(maxA<A.get(i)){
                maxA = A.get(i);
                maxAloc = i;
            }
        }
        for(int j = jdx; j<B.size(); j++){
            if(maxB<B.get(j)){
                maxB = B.get(j);
                maxBloc = j;
            }
        }

        if(maxA == maxB){
            seq.add(maxA);
            sequence(maxAloc+1, maxBloc+1);
        } else if(maxA>maxB){
            A.remove(maxAloc);
            sequence(idx, jdx);
        } else {
            B.remove(maxBloc);
            sequence(idx, jdx);
        }
    }
}