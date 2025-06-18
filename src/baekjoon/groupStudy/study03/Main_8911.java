package baekjoon.groupStudy.study03;
import java.io.*;
public class Main_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            String s = br.readLine();
            int x = 0, y = 0;

            char[] ch = s.toCharArray();
            int xMax = 0, yMax = 0, xMin = 0, yMin = 0;
            int[][] mv = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int dir = 0;
            for(int i = 0; i < s.length(); i++){
                if(ch[i] == 'F') {
                    x += mv[dir][0];
                    y += mv[dir][1];
                } else if(ch[i] == 'L') {
                    dir = (dir+3)%4;
                } else if(ch[i] == 'R') {
                    dir = (dir+1)%4;
                } else {
                    x -= mv[dir][0];
                    y -= mv[dir][1];
                }
                xMax = Math.max(x, xMax);
                yMax = Math.max(y, yMax);
                xMin = Math.min(x, xMin);
                yMin = Math.min(y, yMin);
            }

            System.out.println((xMax-xMin)*(yMax-yMin));
        }
    }
}