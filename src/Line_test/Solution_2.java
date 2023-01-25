package Line_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String [] arr = new String[n];
        for(int i = 0; i<n; i++){
            arr[i] = br.readLine();
        }
        String chat = br.readLine();
        System.out.println(solution(k, arr, chat));
    }

    public static String solution(int k, String[] dic, String chat) {
        String answer = "";
        String [] arr = chat.split(" ");
        boolean [] check = new boolean[arr.length];

        for(int i = 0; i<dic.length; i++){
            for(int j = 0; j<arr.length; j++){
                if(check[j]) break;
                if(isPossible(dic[i], arr[j], k)){
                    arr[j] = makeBlur(arr[j].length());
                    check[j] = true;
                }
            }
        }

        return answer;
    }

    public static boolean isPossible(String dic, String inpu, int k){
        int straight = 0;
        for(int i = 0; i<inpu.length(); i++){
            if(inpu.charAt(i) == '.'){
                straight++;
            }
            else{
                for(int j = straight; j<straight*k; j++){

                }
            }
        }
        return false;
    }


    public static String makeBlur(int n){
        String answer = "";
        for(int i = 0; i<n; i++){
            answer+="#";
        }
        return answer;
    }
}
