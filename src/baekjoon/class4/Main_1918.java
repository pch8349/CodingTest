package baekjoon.class4;

import java.io.*;
import java.util.*;

/**
 * 중위표기식으로 들어온 입력을 후위표기식으로 변환하는 문제.
 * STACK을 사용한 문제
 * 숫자는 입력된 순서대로니 queue에 저장
 * 기호는 역순이니 stack에 저장
 * 기호 우선순위는 (), /*, +- 순으로 된디.
 */
public class Main_1918 {

    // TODO: 숫자도 기호처럼 칸을 나누어야 할듯. 그럼 answer도 칸을 나누어야 할까?
    static Queue<Character> number;
    static List<Stack<Character>> symbol;
    static int symbol_depth;

    static String flushQS(){
        String ans = "";
        while (!number.isEmpty()) {
            ans += number.poll();
        }
        for(int i = symbol_depth; i>=0; i--) {
            while (!symbol.get(i).isEmpty()) {
                ans += symbol.get(i).pop();
            }
        }
        symbol_depth = 0;
        return ans;
    }

    static String flushOneFloor(){
        String ans = "";
        while (!number.isEmpty()) {
            ans += number.poll();
        }
        while(symbol.get(symbol_depth).isEmpty()){
            ans += symbol.get(symbol_depth).pop();
        }

        symbol.remove(symbol_depth);
        symbol_depth -= 1;
        return ans;
    }

    static void Print(String s){
        System.out.println("###################");
        System.out.println(s);
        char num_arr[] = new char[number.size()];
        System.out.println("숫자 큐");
        for(int i = 0; i<number.size(); i++){
            num_arr[i] = number.peek();
            System.out.print(number.poll());
        }
        List<List<Character>> sym_arr = new LinkedList<>();
        for(int i = 0; i<symbol.size(); i++){
            sym_arr.add(new LinkedList<>());
        }
        System.out.println();
        System.out.println("기호 스택");
        for(int i = 0; i<sym_arr.size(); i++){
            for(int j = 0; j<symbol.get(i).size(); j++){
                sym_arr.get(i).add(symbol.get(j).peek());
                System.out.print(symbol.get(j).peek());
            }
            System.out.println();
        }

        for(int i = 0; i<num_arr.length; i++){
            number.add(num_arr[i]);
        }
        for(int i = 0; i<sym_arr.size(); i++){
            for(int j = sym_arr.get(i).size()-1; j>=0; j--){
                symbol.get(i).push(sym_arr.get(i).get(j));
            }
        }
        System.out.println("###################");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String answer = "";

        number = new LinkedList<>();
        symbol = new LinkedList<>();
        symbol.add(new Stack<>());
        for(char c : S.toCharArray()){
            symbol_depth = symbol.size()-1;
            switch (c){
                case '*' :
                case '/' :
                    symbol.get(symbol_depth).push(c);
//                    Print("*, /");
                    break;

                    // 괄호가 생길 시, stack의 차수를 늘려 list[1](stack ) 의 형태로 저장한다.
                    // 이후 괄호가 닫히면 stack은 높은 차수에서 낮은 차수 순으로 더해준다.
                case '(' :
                    symbol.add(new Stack<>());
                    symbol_depth = symbol.size() - 1;
//                    Print("(");
                    break;
                case ')' :
                    answer += flushOneFloor();
//                    Print(")");
                    break;

                // +, - 가 들어온 경우 stack 에 있는 모든 값을 비워야 함.
                case '+' :
                case '-' :
                    // number 큐에 들어있는게 하나면, A+B 까지만 입력된 상태라고 봐야 함.
                    if(number.size()>1) {
                        answer += flushQS();
                    }
                    symbol.get(symbol_depth).push(c);
//                    Print("+, -");
                    break;

                // 숫자가 들어온 경우
                default :
                    number.add(c);
//                    Print("숫자");
                    break;
            }
        }
        answer += flushQS();

        System.out.println(answer);
    }


}
