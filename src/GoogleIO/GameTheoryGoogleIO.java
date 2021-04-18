package GoogleIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class GameTheoryGoogleIO {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T= parseInt(in.nextLine());
        String testCase[]=new String[T];
        int n[]=new int[T];
        for (int i = 0; i < T; i++) {
            testCase[i]=in.nextLine();
        }


        for (int i = 0; i < T ; i++) {
            System.out.println("Case #"+(i+1)+": "+ winner(testCase[i],0,testCase[i].length()-1,'I'));
        }
    }

    private static int winner(String str,int l,int r,char player) {
        char nextPlayer = player=='I'?'O':'I';
        int left=-1,right=-1;
        if(l>r)
            return 1;
        if(str.charAt(l)!=player && str.charAt(r)!=player)
            return (r-l+2);
        else if(str.charAt(l)==player && str.charAt(r)==player) {
            left = winner(str, l + 1, r, nextPlayer);
            right = winner(str, l, r - 1, nextPlayer);
            return Math.max(left,right);
        }
        else if(str.charAt(l)==player){
            return winner(str, l + 1, r, nextPlayer);
        }
        else {
            return winner(str, l, r - 1, nextPlayer);
        }
    }
}
