package baekjoon.class5;
import java.awt.Point;
import java.io.*;
import java.util.*;
public class Main_9252 {
    static String S1, S2;
    static int maxLen;
    static Point LL = new Point(0, 0);
    static int [][] common;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S1 = br.readLine();
        S2 = br.readLine();

        common = new int[S1.length()+1][S2.length()+1];

        for(int i = 1; i<=S1.length(); i++){
            for(int j = 1; j<=S2.length(); j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    common[i][j] = common[i-1][j-1]+1;
                    if(maxLen < common[i][j]){
                        maxLen = common[i][j];
                        LL = new Point(i, j);
                    }
                } else {
                    common[i][j] = Math.max(common[i][j-1], common[i-1][j]);
                }
            }
        }

        List<Character> list = new ArrayList<>();
        while(LL.x>0&&LL.y>0&&common[LL.x][LL.y]>0){
            if(common[LL.x-1][LL.y] == common[LL.x][LL.y]){
                LL.x--;
            } else if(common[LL.x][LL.y-1] == common[LL.x][LL.y]){
                LL.y--;
            } else {
                list.add(S2.charAt(LL.y-1));
                LL.x--;
                LL.y--;
            }
        }

        bw.write(maxLen+"\n");
        for(int i = list.size()-1; i>=0; i--){
            bw.write(list.get(i));
        }
        bw.flush();
    }
}