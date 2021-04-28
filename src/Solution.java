import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static void wordCountEngine(String document) {
        ArrayList<String> al = new ArrayList<>();

        char cur;
        int begin = 0;
        for (int i=0;i<document.length();i++)
        {
            char ch[] = document.toUpperCase().toCharArray();
            cur = ch[i];
            if(cur<65 || cur>90){
                if(cur == ' ') {
                    al.add(document.substring(begin, i));
                    begin=i+1;
                }
                else{
                    document = document.substring(0,i)+document.substring(i+1);
                    i--;
                }
            }
        }
        al.add(document.substring(begin,document.length()));

        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0; i < al.size(); i++) {
            String key = al.get(i).toString().toLowerCase();
            if(hm.containsKey(key))
                hm.put(key,hm.get(key)+1);
            else
                hm.put(key,1);
        }
        hm.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));;

//        for ( Map.Entry<String,Integer> entry: hm.entrySet()) {
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }

        }


    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        wordCountEngine(document);
//        System.out.println((int)'a');
    }

}