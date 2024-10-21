package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_9935 {
    static StringBuilder string;
    static String bomb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = new StringBuilder(br.readLine());
        bomb = br.readLine();
        int len = bomb.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<string.length(); i++){
            stack.add(string.charAt(i));

            if(stack.size()<len) continue;

            boolean flag = true;
            for(int j = 0; j<len; j++){
                if(stack.get(stack.size() - (len - j)) != bomb.charAt(j)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(int j = 0; j<len; j++){
                    stack.pop();
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i<stack.size(); i++){
            ans.append(stack.get(i));
        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else System.out.println(ans);
    }
}