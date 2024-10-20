package baekjoon.sprout;
import java.io.*;
public class Main_2754 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int ans = 0;

        switch(s.charAt(0)){
            case 'A' :
                ans+=40;
                break;
            case 'B':
                ans+=30;
                break;
            case 'C':
                ans+=20;
                break;
            case 'D':
                ans+=10;
                break;
        }
        if(ans != 0) {
            switch (s.charAt(1)) {
                case '+':
                    ans += 3;
                    break;
                case '-':
                    ans -= 3;
                    break;
            }
        }
        int a = ans/10;
        int b = ans%10;
        System.out.println(a+"."+b);
    }
}
