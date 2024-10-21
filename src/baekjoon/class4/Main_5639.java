package baekjoon.class4;
import java.io.*;
import java.util.*;
public class Main_5639 {
    static class Node{
        int num;
        Node l, r;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node l, Node r){
            this.num = num;
            this.l = l;
            this.r = r;
        }

        void insert(int n){
            if(n < this.num) {
                if(this.l == null) this.l = new Node(n);
                else this.l.insert(n);
            } else {
                if(this.r == null) this.r = new Node(n);
                else this.r.insert(n);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while(true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.l);
        postOrder(node.r);
        System.out.println(node.num);
    }

}