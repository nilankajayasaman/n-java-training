import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortWithLambda {

    public static void main(String[] args) {

        List<Student> students = Student.getStudent();

        Collections.sort(students,(s1,s2)->new Integer(s1.getId()).compareTo(s2.getId()));

        System.out.println(students);

        //        reverse the list
        Collections.sort(students,(s1,s2)->-new Integer(s1.getId()).compareTo(s2.getId()));

        System.out.println(students);

    }

}
