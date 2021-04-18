package GoogleIO;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ImpartialOfferingGoogleWIO {
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

            System.out.println("Case #"+(i+1)+": "+minTreats(pets));
        }
    }

    private static int minTreats(int[] pets) {
//        Print.printArray(pets);
        int n=pets.length;


        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            if(map.containsKey(pets[i])) {
                map.put(pets[i], map.get(pets[i])+1);
            }
            else
                map.put(pets[i],1);
        }
        TreeMap<Integer,Integer> tm=new  TreeMap<Integer,Integer> (map);

        Iterator itr=tm.keySet().iterator();
        int treats=0;
        int initial=1;
        while(itr.hasNext())
        {
            int key=(int)itr.next();
            treats += initial*map.get(key);
            initial++;
        }
        return treats;
    }
}