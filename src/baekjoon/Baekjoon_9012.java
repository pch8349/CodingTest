package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t<tc; t++){
            boolean flag = true;
            String s = br.readLine();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='('){
                    stack.push(1);
                }
                else {
                    if (stack.empty()) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    } else stack.pop();
                }
            }
            if(flag){
                if(stack.empty()) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}