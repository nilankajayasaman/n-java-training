import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortWithStream {

    public static void main(String[] args) {

        List<Student> students = Student.getStudent();
        System.out.println(students);
        List<Student> students1 = students.stream().sorted(new StudentComparator()).collect(Collectors.toList());
        System.out.println(students1);

        List<Student> students2 = students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
        System.out.println(students2);



    }

}
