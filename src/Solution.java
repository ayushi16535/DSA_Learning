import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution{
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

    private static String winner(String str,int l,int r,char player) {
        char nextPlayer = player=='I'?'O':'I';
        int left=-1,right=-1;
        if(l>r)
            return nextPlayer+" "+1;
        if(str.charAt(l)!=player && str.charAt(r)!=player)
            return nextPlayer+" "+(r-l+2);
        else if(str.charAt(l)==player && str.charAt(r)==player) {
            String leftstr=winner(str, l + 1, r, nextPlayer);
            String rightstr=winner(str, l, r - 1, nextPlayer);
            left = Integer.parseInt(leftstr.split(" ")[1]);
            right = Integer.parseInt(rightstr.split(" ")[1]);

            if(left>right)
                return leftstr;
            else
                return rightstr;
        }
        else if(str.charAt(l)==player){
            return winner(str, l + 1, r, nextPlayer);
        }
        else {
            return winner(str, l, r - 1, nextPlayer);
        }
    }
    }
