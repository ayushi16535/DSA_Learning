import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    int marks;
    int age;
    String name;

    public Student(int marks, int age, String name) {
        this.marks = marks;
        this.age = age;
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "marks=" + marks +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
////    method1 using comparable
//    @Override
//    public int compareTo(Object o) {
//        Student that=(Student)o;
//        return this.age-that.age;
//    }
public static void main(String[] args) {

    List<Student> list=new ArrayList<>();

    list.add(new Student(10,23,"Ayushi"));
    list.add(new Student(8,18,"Shalu"));
    list.add(new Student(11,3,"Bhalu"));
    list.add(new Student(12,3,"Paras"));

//    //method2 using comparator
//    Collections.sort(list, new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.age-o2.age;
//        }
//    });

//    //method3 using lambda
//    Collections.sort(list,((o1, o2) -> o1.age-o2.age));

//    method4 using built-in comparator
    Collections.sort(list, Comparator.comparing(Student::getAge).thenComparing(Student::getMarks).reversed());

    list.forEach(System.out::println);
}
}
