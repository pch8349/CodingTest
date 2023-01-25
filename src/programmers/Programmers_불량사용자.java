package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Programmers_불량사용자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []user = new String[5];
        String []bann = new String[4];
        for(int i = 0; i<5; i++){
            user[i] = br.readLine();
        }
        for(int j = 0; j<4; j++){
            bann[j] = br.readLine();
        }
        System.out.println(solution(user, bann));
    }
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ArrayList<Integer>[] banned_cnt = new ArrayList[banned_id.length];
        int result[] = new int[(int)(Math.pow(2, banned_id.length))];
        for(int i = 0; i<banned_id.length; i++){
            for(int j = 0; j<user_id.length; j++){
                boolean flag = true;
                if(banned_id[i].length() != user_id[j].length()) continue;
                for(int k = 0; k<banned_id[i].length(); k++) {
                    if (banned_id[i].charAt(k) == '*') continue;
                    if (banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    if(banned_cnt[i] == null) banned_cnt[i] = new ArrayList();
                    banned_cnt[i].add(j);
                }
            }
        }
         for(int i = 0; i<banned_cnt.length; i++){
             for(int j = 0; j<banned_cnt.length; j++){
//                 if(banned_cnt[])
             }
         }
        return answer;
    }
}
