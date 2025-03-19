package baekjoon.gold;
import java.io.*;
import java.util.*;
public class Main_2504 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;

        stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(0);
            } else if(s.charAt(i) == ')'){
                if(!stackSeeker(2)) return;
            } else if(s.charAt(i) == '['){
                stack.push(1);
            }else if(s.charAt(i) == ']'){
                if(!stackSeeker(3)) return;
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == 0 || stack.peek() == 1) { // ()( 와 같은 구조 체크
                System.out.println(0);
                return;
            }
            ans += stack.pop();
        }

        System.out.println(ans);
    }

    static boolean stackSeeker(int n){
        // (()()()) 같은 구조면, (222) 이렇게 저장되있기 때문에, 2들을 다 더한 후 '('를 찾는다.
        // 따라서 (2+2+2) * 2 로 계산하기 위한 temp 변수 선언
        int temp = 0;

        while (true) {
            if(stack.isEmpty() || stack.peek() == 3-n){ // 3-']'(3) 하면 '(' 인 0 인지 찾을 수 있음, 3-')'(2) 하면 '[' 인 1인지 찾을 수 있음
                System.out.println(0);
                return false;
            } else if(stack.peek() == n-2) {
                stack.pop();

                if (temp == 0) {
                    stack.push(n);
                } else {
                    stack.push(temp * n);
                }

                break;
            } else {
                temp += stack.pop();
            }
        }
        return true;
    }
}