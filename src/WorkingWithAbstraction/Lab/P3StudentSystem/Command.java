package WorkingWithAbstraction.Lab.P3StudentSystem;

public interface Command {

    void execute(StudentRepository repository, String[] args);
}
