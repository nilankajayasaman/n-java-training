import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Student> students = Student.getStudent();

        Collections.sort(students,new StudentComparator());

        System.out.println(students);

    }

}
