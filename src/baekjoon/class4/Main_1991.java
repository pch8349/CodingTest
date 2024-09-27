package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_1991 {
    static int N;
    static int tree[][] = new int[27][3]; // 1.부모, 2.자식 왼쪽, 3.자식 오른쪽
    static String ans;
    static boolean visit[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int arr[] = new int[3];

            for(int j=0; j<3; j++){

                String S = st.nextToken();

                arr[j] = S.equals(".") ? 0 : S.charAt(0) - 'A' + 1;
            }

            // 부모노드에서 자식 체크
            tree[arr[0]][1] = arr[1];
            tree[arr[0]][2] = arr[2];

            // 자식노드에서 부모 체크
            tree[arr[1]][0] = arr[0];
            tree[arr[2]][0] = arr[0];
        }

        ans = "A";
        visit = new boolean[27];
        visit[0] = true;
        visit[1] = true;
        preorder(1);
        System.out.println(ans);

        ans = "";
        visit = new boolean[27];
        visit[0] = true;
        inorder(1);
        System.out.println(ans);

        ans = "";
        visit = new boolean[27];
        visit[0] = true;
        postorder(1);
        System.out.println(ans);
    }

    static void preorder(int now){
        if(visit[tree[now][1]] == false){
            ans += (char)(tree[now][1]+'A'-1);
            visit[tree[now][1]] = true;
            preorder(tree[now][1]);
        }
        if(visit[tree[now][2]] == false){
            ans += (char)(tree[now][2]+'A'-1);
            visit[tree[now][1]] = true;
            preorder(tree[now][2]);
        }
    }

    static void inorder(int now){
        if(tree[now][1] != 0 && visit[tree[now][1]] == false){
            inorder(tree[now][1]);
        }
        if(visit[now] == false){
            ans += (char)(now + 'A' - 1);
            visit[now] = true;
        }
        if(visit[tree[now][2]] == false){
            inorder(tree[now][2]);
        }
    }

    static void postorder(int now){
        // 왼쪽 리프까지 내려가기
        if(tree[now][1] != 0 && visit[tree[now][1]] == false){
            postorder(tree[now][1]);
        }
        // 오른쪽
        if(visit[tree[now][2]] == false){
            postorder(tree[now][2]);
            ans += (char) (now + 'A' - 1);
            visit[now] = true;
        }
        if(visit[now] == false) {
            ans += (char) (now + 'A' - 1);
            visit[now] = true;
        }
    }
    
}
