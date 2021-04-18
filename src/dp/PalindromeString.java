package dp;

import java.util.HashMap;

public class PalindromeString {
    static int countRecursion=0;
    static int countRecursionDP=0;
    public static void main(String[] args) {
        String str="ACBCDBAA";
        int length=str.length();
        System.out.println(minDeletions(str,0,length-1)+" "+minDeletionsDP(str,0,length-1,new HashMap<String,Integer>()));
        System.out.println(countRecursion+" "+countRecursionDP);
    }

    //pure recursion
    private static int minDeletions(String str, int i, int j) {
        countRecursion++;
        if(i>=j)
            return 0;
        if(str.charAt(i) == str.charAt(j))
        return minDeletions(str,i+1,j-1);
        return 1+Math.min(minDeletions(str,i+1,j), minDeletions(str,i,j-1));
    }

    private static int minDeletionsDP(String str,int i,int j,HashMap<String,Integer> map){
        countRecursionDP++;
        if(i>=j)
            return 0;
        int count=0;
        String key=i+"|"+j;


        if(map.containsKey(key))
            return map.get(key);
        else if(str.charAt(i) == str.charAt(j))
            count= minDeletionsDP(str,i+1,j-1,map);
        else
        count= 1+Math.min(minDeletionsDP(str,i+1,j,map), minDeletionsDP(str,i,j-1,map));

        map.put(key,count);
        return count;
    }
}
