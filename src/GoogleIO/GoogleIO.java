package GoogleIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class GoogleIO {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T= parseInt(in.nextLine());
        String testCase[]=new String[T];
        for (int i = 0; i < T; i++) {
            testCase[i]=in.next();
        }
        int count[]=new int[T];
        for (int i = 0; i < T; i++) {
//            System.out.println(testCase[i]);
            String str=testCase[i];
//            char ch[]=str.toCharArray();
            HashSet<Character> set=new HashSet<>();
            for (int j = 0; j < str.length(); j++) {
                char ch=str.charAt(j);
                if(ch=='I'||ch=='i')
                    set.add(ch);
                else{
                    if(ch=='O'&&set.contains('I'))
                    {
                        count[i]++;
                        set.remove('I');
                    }
                }
            }
        }
        for (int i = 0; i < T; i++) {
            System.out.println("Case #"+(i+1)+": "+count[i]);
        }
    }
}
