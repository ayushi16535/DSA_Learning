import java.util.HashSet;

public class Permutation {
//    static int count=0;
    static HashSet<String> hs=new HashSet<>();
    public static void main(String[] args) {
        String s="ABCC";
        printALL(s,0,3);
//        System.out.println(count);
//        System.out.println(interChangeChar(s,1,2));
    }
    static void printALL(String s,int l,int r){
//        count++;
        if(l==r) {
            if(hs.contains(s)) return;
            hs.add(s);
            System.out.println(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            s=interChangeChar(s,l,i);
            printALL(s,l+1,r);
            s=interChangeChar(s,l,i);
        }
    }

    static String interChangeChar(String s,int a, int b){
        char charArray[]=s.toCharArray();
        char temp=charArray[a];
        charArray[a]=charArray[b];
        charArray[b]=temp;
        return String.valueOf(charArray);
    }
}
