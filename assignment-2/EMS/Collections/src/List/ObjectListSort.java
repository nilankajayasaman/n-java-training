package List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectListSort {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();



        students.add(new Student(3345,"nilanka","ja-ela"));
        students.add(new Student(2656,"amila","wattla"));
        students.add(new Student(7832,"thilina","colomobo"));
        students.add(new Student(3326,"pubudu","nuwara"));
        students.add(new Student(4526,"deshan","negambo"));
        students.add(new Student(9652,"ruchineth","kandana"));
        students.add(new Student(5632,"zack","mabola"));
        students.add(new Student(7514,"koon","katana"));
        students.add(new Student(8923,"kim","siduwa"));
        students.add(new Student(1452,"adele","raddolugama"));


        students.forEach(student -> {
            System.out.println("==============");
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.city);
            System.out.println("==============");
        });
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("--------------------------------");

        students.forEach(student -> {
            System.out.println("==============");
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.city);
            System.out.println("==============");
        });

        System.out.println("--------------------------------");

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });


        Collections.sort(students,new StudentComparator());

        System.out.println("--------------------------------");

        students.forEach(student -> {
            System.out.println("==============");
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.city);
            System.out.println("==============");
        });
        Collections.sort(students);

        System.out.println("--------------------------------");
        students.forEach(student -> {
            System.out.println("==============");
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.city);
            System.out.println("==============");
        });


    }

}
