package baekjoon;

import java.util.*;

public class Main_1484 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();

        int ll = 1;
        int rr = 1;
        List<Integer>list = new ArrayList<>();
        while(rr*rr - (rr-1)*(rr-1)<=G){

            if(rr*rr-ll*ll<G) {
                rr++;
            } else if(rr*rr-ll*ll>G){
                ll++;
            } else {
                list.add(rr++);
            }
        }
        if(list.size()==0){
            list.add(-1);
        }
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
