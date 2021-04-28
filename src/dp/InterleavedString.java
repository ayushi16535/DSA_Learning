//https://www.techiedelight.com/check-string-interleaving-two-given-strings/
package dp;

public class InterleavedString {
    public static void main(String[] args) {
        String a = "ABC";
        String b = "ACD";

        String c = "ACDABC";
        System.out.println(interleaved(a,b,c,0,0,0));
    }

    public static boolean interleaved(String a, String b, String c,int na,int nb, int nc){

        if(na == a.length() && nb == b.length() && nc == c.length())
            return true;

        boolean A = na<a.length() && nc < c.length() && a.charAt(na) == c.charAt(nc) &&interleaved(a, b, c, na + 1, nb, nc + 1);

        boolean B = nb<b.length() && nc < c.length() && b.charAt(nb) == c.charAt(nc) && interleaved(a, b, c, na,nb + 1,nc + 1);

        return A || B;
    }
}
