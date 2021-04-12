import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution{
    public static void main(String[] args) {

        List<Student> list=new ArrayList<>();

        list.add(new Student(10,23,"Ayushi"));
        list.add(new Student(8,18,"Shalu"));
        list.add(new Student(11,3,"Bhalu"));
        list.add(new Student(12,3,"Paras"));

        Collections.sort(list, Comparator.comparing(Student::getAge).thenComparing(Student::getMarks).reversed());

        list.forEach(System.out::println);
    }
}