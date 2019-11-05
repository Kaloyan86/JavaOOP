package WorkingWithAbstraction.Lab.P3StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String,Student> students ;

    public StudentRepository() {
        this.students = new HashMap<>();
    }

    public boolean containsKey(String name) {
        return this.students.containsKey(name);
    }

    public void registerStudent(String name, Student student) {
        this.students.put(name,student);
    }

    public Student findOneByName(String name) {
        return this.students.get(name);
    }
}
