import java.util.*;

class MyString {
    String str;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return this.hashCode()==myString.hashCode();
    }

    MyString(String str){
        this.str=str;
    }
    @Override
    public int hashCode() {
        int hash=0;
        for (int i = 0; i < str.length(); i++) {
            hash+=str.charAt(i);
        }
        return hash;
    }
}

public class Anagrams {

    public static void main(String[] args) {
        String str[]={"eat","tea","tan","ate","nat","bat"};
        System.out.println(new MyString("eat").equals(new MyString("ate")));
    }
}
