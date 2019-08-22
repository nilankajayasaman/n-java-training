import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        printStudentsWithShortNames();
        filterWithStream();
        processWithStream();
        countWithStream();
        maxWithStream();
        minWithStream();
    }

    static void minWithStream(){

        System.out.println("Ordered First Name"+Student.getStudent().stream()
                .min((Student s1,Student s2)-> s1.getName().compareTo(s2.getName())));

        System.out.println("Maximum Student id"+Student.getStudent().stream()
                .min(Comparator.comparing(student -> student.getId())));

    }

    static void maxWithStream(){

        System.out.println("Ordered Last Name"+Student.getStudent().stream()
                .max((Student s1,Student s2)-> s1.getName().compareTo(s2.getName())));

        System.out.println("Maximum Student id"+Student.getStudent().stream()
                .max(Comparator.comparing(student -> student.getId())));

    }

    static void countWithStream(){

        System.out.println(Student.getStudent().stream().filter(s->s.getId()<25).count());

    }

    static void processWithStream(){

        Student.getStudent().stream()
                .map(s->new Student("Dr "+s.getName(),s.getId()))
                .collect(Collectors.toList())
                .forEach(s-> System.out.println(s.getName()+" "+s.getId()));

    }

    static void filterWithStream(){
        List<Student> students = Student.getStudent().stream().filter(s->s.getName().length()<=6).collect(Collectors.toList());
        System.out.println(students);
    }

    static void printStudentsWithShortNames(){

        List<Student> students = Student.getStudent();
        for (Student student:students){
            if (student.getName().length()<=6){
                System.out.println(student.getName());
            }
        }
    }



}
