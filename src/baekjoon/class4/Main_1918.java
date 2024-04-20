package baekjoon.class4;

import java.io.*;
import java.util.*;

/**
 * 중위표기식으로 들어온 입력을 후위표기식으로 변환하는 문제.
 * STACK을 사용한 문제
 * 기호는 역순이니 stack에 저장
 * stack 에 저장된 기호는 +, -, *, / 는 스택에 쌓고, ( 가 나오면, ) 가 나올때까지만 반환.
 *
 */
public class Main_1918 {

    static Stack<Character> symbol;
    static String answer ;

    static void priority(){

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        symbol = new Stack<>();
        answer = "";

        for(char c : S.toCharArray()){
            switch (c){
                case '(' :
                    symbol.add(c);
                    break;

                case '*' :
                case '/' :
                case '+' :
                case '-' :
                    while(!symbol.isEmpty() && (priority(symbol.peek()) >= priority(c))){
                        answer += symbol.pop();
                    }
                    symbol.add(c);
                    break;

                case ')' :
                    while(symbol.peek()!='('){
                        answer += symbol.pop();
                    }
                    symbol.pop();
                    break;

                // 숫자가 들어온 경우
                default :
                    answer += c;
            }
        }

        while (!symbol.isEmpty()) {
            answer += symbol.pop();
        }

        System.out.println(answer);
    }

    public static int priority(char operator){

        if(operator=='(' || operator==')'){
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

}
