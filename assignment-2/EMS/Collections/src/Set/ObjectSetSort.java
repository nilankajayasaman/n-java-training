package Set;

import List.Student;

import java.util.HashSet;
import java.util.Set;

public class ObjectSetSort {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();
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
        students.add(new Student(1452,"aele","raddolugama"));
        students.add(new Student(1452,"adele","raddolugama"));

        students.forEach(student -> {
            System.out.println("==============");
            System.out.println(student.id);
            System.out.println(student.name);
            System.out.println(student.city);
            System.out.println("==============");
        });

    }

}
