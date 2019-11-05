package WorkingWithAbstraction.Lab.P3StudentSystem;

public class ShowCommand implements Command {
    public void execute(StudentRepository repo, String[] args) {
        String name = args[1];
        if (repo.containsKey(name)) {
            Student student = repo.findOneByName(name);
            String view = student.toString();
            System.out.println(view);
        }
    }
}
