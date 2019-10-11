package List;

import java.util.Objects;

public class Student implements Comparable<Student> {

    public int id;
    public String name;
    public String city;

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public int compareTo(Student o) {
        return this.city.compareTo(o.city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                name.equals(student.name) &&
                city.equals(student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }
}
