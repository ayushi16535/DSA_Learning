package GoogleIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class InconstantOrderingGoogleIO {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T= parseInt(in.nextLine());
        String testCase[]=new String[T];
        int n[]=new int[T];
        for (int i = 0; i < T; i++) {
            n[i]=parseInt(in.nextLine());
            testCase[i]=in.nextLine();
        }

//        System.out.println(n[1]+"\n"+testCase[1]);

        for (int i = 0; i < T; i++) {
            int pets[]=new int[n[i]];
            for (int j = 0; j < n[i]; j++) {
                pets[j]=Integer.parseInt(testCase[i].split(" ")[j]);
            }

            System.out.println("Case #"+(i+1)+": "+ validString(pets));
        }
    }

    private static String validString(int[] blocks) {
//        Print.printArray(pets);
        int n=blocks.length;
        String str="A";
        int maxReverse=0;
        for (int i = 1; i < n ; i=i+2) {
            maxReverse=Math.max(maxReverse,blocks[i]);
        }
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                String temp="";
                int lastChar = str.charAt(str.length()-1);
                for (int j = lastChar+1; j < lastChar+1+blocks[i]; j++) {
                    temp += (char) j;
                }
                str = str+temp;
            }
            else{
                String temp="";
                for (int j = 64+blocks[i]; j >=65 ; j--) {
                    temp += (char)j;
                }
                str = str+temp;
            }
        }

        int endChar=0;
        for (int i = 0; i < n; i++) {
            endChar += blocks[i];
            if(i%2==0 && str.length()>1+endChar && str.charAt(endChar)<=str.charAt(1+endChar))
                str = str.substring(0,endChar)+(char)((int)str.charAt(1+endChar)+1)+str.substring(1+endChar);
        }


        return str;
    }
}